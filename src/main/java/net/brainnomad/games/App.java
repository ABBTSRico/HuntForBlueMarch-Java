package net.brainnomad.games;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App {
    private GameBoard ocean;

    public App() {
        ocean = new GameBoard();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        App huntApp = new App();
        while (true) {
            System.out.print("Our orders, Sir: ");
            String order = scan.next();
            switch (order.toLowerCase().charAt(0)) {
            case 's':
                huntApp.ocean.keySonar();
                break;
            case 'b':
                huntApp.ocean.keyDropBomb();
                break;
            default:
                huntApp.ocean.keyMoveDestroyer(order);
            }
        }
    }
}
