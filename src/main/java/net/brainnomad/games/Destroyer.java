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

    public void moveVessel(int newX, int newY) {
        xPos = newX;
        yPos = newY;
    }

    public int distance(Submarine submarine) {
        int[] subPos = submarine.getPosition();
        int distance = (xPos - subPos[0]) * (xPos - subPos[0]) + (yPos - subPos[1]) * (yPos - subPos[1]);
        return distance;
    }
}