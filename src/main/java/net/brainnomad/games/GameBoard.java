package net.brainnomad.games;

import java.util.Random;

class GameBoard {
    private int boardWidth, boardHeight;
    private Submarine submarine;
    private Destroyer destroyer;

    private final int MARGIN = 5;

    public GameBoard() {
        boardWidth = 30;
        boardHeight = boardWidth;

        Random rand = new Random();
        int subPosX = rand.nextInt(boardWidth - 2 * MARGIN) + MARGIN;
        int subPosY = rand.nextInt(boardHeight - 2 * MARGIN) + MARGIN;
        submarine = new Submarine(subPosX, subPosY);
        destroyer = new Destroyer(20, 20);
    }

    public int getBoardWith() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public void keySonar() {
        if (destroyer.readSonar(submarine)) {
            System.out.println("Submarine nearby, Sir!");
        } else {
            System.out.println("Nothing nearby, Sir!");
        }
    }

    public void keyMoveDestroyer(char key) {
        String moveToMessage;
        boolean moveSuccessful = false;

        switch (key) {
        case 'a':
            moveSuccessful = destroyer.moveVessel(Directions.LEFT, this);
            break;
        case 'd':
        moveSuccessful = destroyer.moveVessel(Directions.RIGHT, this);
            break;
        case 'w':
        moveSuccessful = destroyer.moveVessel(Directions.UP, this);
            break;
        case 'x':
        moveSuccessful = destroyer.moveVessel(Directions.DOWN, this);
            break;
        default:
            moveToMessage = "to unknown direction";
        }

        if (moveSuccessful) {
            System.out.println("Destroyer moved to " + destroyer.getPosition());
        } else {
            System.out.println("Wrong direction, Sir. We would leave the map!");
        }
    }
}