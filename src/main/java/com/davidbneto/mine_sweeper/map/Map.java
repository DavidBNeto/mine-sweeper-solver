package com.davidbneto.mine_sweeper.map;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Map {

    private final int sizeX;
    private final int sizeY;
    private final int bombs;
    private final int [][] mineField;
    private final Random random;
    private final Difficulty difficulty;

    public Map(final int sizeX, final int sizeY, final Difficulty difficulty) throws NoSuchAlgorithmException {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.difficulty = difficulty;
        this.bombs = difficulty.getBombs(sizeX * sizeY);
        this.mineField = new int[sizeX][sizeY];
        this.random = SecureRandom.getInstanceStrong();
        startMap();
    }

    private void startMap(){
        int bombsSet = 0;
        int bombX;
        int bombY;
        while (bombsSet < bombs) {
            bombX = this.random.nextInt(sizeX);
            bombY = this.random.nextInt(sizeY);
            if (mineField[bombX][bombY] != -1) {
                mineField[bombX][bombY] = -1;
                bombsSet++;
            }
        }
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeX; y++) {
                mineField[x][y] = isAMine(x,y) ? - 1 : countSurroundingMines(x,y);
            }
        }
    }

    private int countSurroundingMines(final int x, final int y){
        return (isAMine(x + 1, y) ? 1 : 0) +
                (isAMine(x + 1, y + 1) ? 1 : 0) +
                (isAMine(x, y + 1) ? 1 : 0) +
                (isAMine(x - 1, y + 1) ? 1 : 0) +
                (isAMine(x - 1, y) ? 1 : 0) +
                (isAMine(x - 1, y - 1) ? 1 : 0) +
                (isAMine(x, y - 1) ? 1 : 0) +
                (isAMine(x + 1, y - 1) ? 1 : 0);
    }

    public boolean isAMine(final int x, final int y) {
        return x >= 0 &&
                y >= 0 &&
                x < sizeX &&
                y < sizeY &&
                mineField[x][y] == -1;
    }

    public int[][] getMineField() {
        return mineField;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getBombs() {
        return bombs;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
