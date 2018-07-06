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
        int subPosX = 20; //rand.nextInt(boardWidth - 2 * MARGIN) + MARGIN;
        int subPosY = 10; //rand.nextInt(boardHeight - 2 * MARGIN) + MARGIN;
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

    public boolean keyDropBomb() {
        boolean hitSubmarine = destroyer.dropBomb(submarine);
        if (hitSubmarine) {
            System.out.println("Direct hit Sir!");
        } else {
            System.out.println("We missed 'em, Sir!");
        }
        return hitSubmarine;
    }

    public void keyMoveDestroyer(String key) {
        int oldXPos = destroyer.getPosition()[0];
        int oldYPos = destroyer.getPosition()[1];
        int newXPos = oldXPos;
        int newYPos = oldYPos;

        switch (key.charAt(0)) {
        case 'a':
            newXPos = oldXPos - 1;
            break;
        case 'd':
            newXPos = oldXPos + 1;
            break;
        case 'w':
            newYPos = oldYPos - 1;
            break;
        case 'x':
            newYPos = oldYPos + 1;
            break;
        }

        if (isValidMove(newXPos, newYPos)) {
            destroyer.moveVessel(newXPos, newYPos);
            System.out.println("Destroyer moved to " + destroyer.getPosition()[0] + "," + destroyer.getPosition()[1]);
        } else {
            System.out.println("Wrong direction, Sir. We would leave the map!");
        }
    }

    private boolean isValidMove(int xNew, int yNew) {
        if ((xNew >= 0 && xNew <= getBoardWith()) && (yNew >= 0 && yNew <= getBoardHeight())) {
            return true;
        }
        return false;
    }
}