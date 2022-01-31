package com.davidbneto.mine_sweeper.map;

public enum Difficulty {

    VERY_EASY(0.065),
    EASY(0.125),
    MEDIUM(0.1625),
    HARD(0.20625),
    VERY_HARD(0.25);

    final double percentage;

    Difficulty(final double percentage) {
        this.percentage = percentage;
    }

    public int getBombs(final int size) {
        return ((int) Math.floor(this.percentage * size));
    }

}
