package net.brainnomad.games;

/**
 * Hello world!
 *
 */
public class App 
{
    private GameBoard ocean;

    public App() {
        ocean = new GameBoard();
    }

    public static void main( String[] args )
    {
        App huntApp = new App();
        huntApp.ocean.keySonar();
        huntApp.ocean.keyMoveDestroyer('a');
    }
}
