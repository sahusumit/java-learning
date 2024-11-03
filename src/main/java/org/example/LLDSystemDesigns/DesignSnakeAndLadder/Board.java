package org.example.LLDSystemDesigns.DesignSnakeAndLadder;

import org.example.LLDSystemDesigns.DesignBookMyShow.Theater;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    public Board(int boardSize, int snake, int ladder) {
        initializeCell(boardSize);
        addSnakeAndLadders(cells, snake, ladder);
    }

    private void initializeCell(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
    }

    private void addSnakeAndLadders(Cell[][] cells, int snake, int ladder) {
        while (snake > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if (snakeTail >= snakeHead) {
                continue;
            }
            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;
            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;
            snake--;
        }

        while (ladder > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if (ladderEnd <= ladderStart) {
                continue;
            }
            Jump ladderObj = new Jump();
            ladderObj.start = ladderStart;
            ladderObj.end = ladderEnd;
            Cell cell = getCell(ladderStart);
            cell.jump = ladderObj;
            ladder--;
        }
    }

    public Cell getCell(int playerPosition) {
        int row = playerPosition/cells.length;
        int col = playerPosition % cells.length;
        return cells[row][col];
    }

}
