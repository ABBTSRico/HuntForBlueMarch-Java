package net.brainnomad.games;

class Destroyer {
    private int xPos, yPos;

    public Destroyer(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public int[] getPosition() {
        int[] pos = new int[2];
        pos[0] = xPos;
        pos[1] = yPos;
        return pos;
    }

    public boolean readSonar(Submarine submarine) {
        if (distance(submarine) <= 100) {
            return true;
        }
        return false;
    }

    public boolean moveVessel(int direction, GameBoard board) {
        int xNew, yNew;

        switch (direction) {
        case Directions.LEFT:
            xNew = xPos - 1;
            if (isValidMove(xNew, yPos, board)) {
                xPos = xNew;
            } else {
                return false;
            }
            break;
        case Directions.RIGHT:
            xNew = xPos + 1;
            if (isValidMove(xNew, yPos, board)) {
                xPos = xNew;
            } else {
                return false;
            }
            break;
        case Directions.UP:
            yNew = yPos - 1;
            if (isValidMove(xPos, yNew, board)) {
                yPos = yNew;
            } else {
                return false;
            }
            break;
        case Directions.DOWN:
            yNew = yPos + 1;
            if (isValidMove(xPos, yNew, board)) {
                yPos = yNew;
            } else {
                return false;
            }
            break;
        }
        return true;

    }

    public int distance(Submarine submarine) {
        int[] subPos = submarine.getPosition();
        int distance = (xPos - subPos[0]) * (xPos - subPos[0]) + (yPos - subPos[1]) * (yPos - subPos[1]);
        return distance;
    }

    private boolean isValidMove(int xNew, int yNew, GameBoard board) {

        if ((xNew >= 0 && xNew <= board.getBoardWith()) && (yNew >= 0 && yNew <= board.getBoardHeight())) {
            return true;
        }
        return false;
    }
}