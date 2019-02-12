package net.brainnomad.games;

import java.util.Random;

class GameBoard {
    private final int boardWidth;
    private final int boardHeight;
    private final Submarine submarine;
    private Destroyer destroyer;

    private final int MARGIN = 5;

    public GameBoard() {
        boardWidth = 20;
        boardHeight = boardWidth;

        Random rand = new Random();
        int initPosX = rand.nextInt(boardWidth - 2 * MARGIN) + MARGIN;
        int initPosY = rand.nextInt(boardHeight - 2 * MARGIN) + MARGIN;
        submarine = new Submarine(initPosX, initPosY);
        do {
            initPosX = rand.nextInt(boardWidth - 2 * MARGIN) + MARGIN;
            initPosY = rand.nextInt(boardHeight - 2 * MARGIN) + MARGIN;
            destroyer = new Destroyer(initPosX, initPosY);
        } while(checkCollision());
    }

    private boolean checkCollision() {
        return submarine.checkCollision(destroyer);
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
        displaySonarMap();
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

    private void displaySonarMap() {
        int sonarRange = destroyer.getSonarRange();

        int xmin = destroyer.getPosition()[0] - sonarRange;
        if (xmin < 0) {
            xmin = 0;
        }

        int xmax = destroyer.getPosition()[0] + sonarRange;
        if (xmax > boardWidth) {
            xmax = boardWidth;
        }

        int ymin = destroyer.getPosition()[1] - sonarRange;
        if (ymin < 0) {
            ymin = 0;
        }

        int ymax = destroyer.getPosition()[1] + sonarRange;
        if (ymax > boardHeight) {
            ymax = boardHeight;
        }

        for (int y = ymin; y <= ymax; y++) {
            for (int x = xmin; x <= xmax; x++) {
                if (x == destroyer.getPosition()[0] && y == destroyer.getPosition()[1]) {
                    System.out.print("X");
                } else if (x == submarine.getPosition()[0] && y == submarine.getPosition()[1]) {
                    System.out.print("S");
                } else if (x == 0 || x == boardWidth) {
                    System.out.print("|");
                } else if (y == 0 || y == boardHeight) {
                    System.out.print("_");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}