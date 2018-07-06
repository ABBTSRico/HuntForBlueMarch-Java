package net.brainnomad.games;

class Submarine {
    private int xPos, yPos;

    public Submarine(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public int[] getPosition() {
        int[] pos = new int[2];
        pos[0] = xPos;
        pos[1] = yPos;
        return pos;
    }

    public boolean checkCollision(Destroyer destroyer) {
        int[] destroyerPos = destroyer.getPosition();

        if (destroyerPos[0] == xPos && destroyerPos[1] == yPos) {
            return true;
        }
        return false;
    }
}
