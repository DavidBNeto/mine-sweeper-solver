package com.davidbneto.mine_sweeper;

import com.davidbneto.mine_sweeper.map.Difficulty;
import com.davidbneto.mine_sweeper.map.Map;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

class MapTest {

    @Test
    @DisplayName("Check bomb count")
    void bombCheck() throws NoSuchAlgorithmException {
        final Map map = new Map(10, 10, Difficulty.HARD);
        assertEquals(20, map.getBombs());
    }

    @Test
    @DisplayName("Check map assembly")
    void mapAssemblyCheck() throws NoSuchAlgorithmException{
        final Map map = new Map(10, 10, Difficulty.HARD);
        assertInstanceOf(Map.class, map);
        assertEquals(Difficulty.HARD, map.getDifficulty());
        assertEquals(10, map.getSizeX());
        assertEquals(10, map.getSizeY());
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                assertTrue(wasProperlyInitialized(map.getMineField()[x][y]));
            }
        }
    }

    private boolean wasProperlyInitialized(final int location) {
        return location >= -1 && location <= 8;
    }
}
