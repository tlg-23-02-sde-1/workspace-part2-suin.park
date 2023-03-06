package com.duckrace;

import static com.duckrace.Reward.*;

class BoardTest {

    public static void main(String[] args) {
        Board board = new Board();

        board.dumpStudentIdMap();
        System.out.println();

        board.update(2, PRIZES);
        board.update(9, DEBIT_CARD);
        board.update(1, PRIZES);
        board.update(14,PRIZES);
        board.update(14,PRIZES);
        board.renderRaceMap();
    }
}