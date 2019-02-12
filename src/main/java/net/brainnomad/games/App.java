package net.brainnomad.games;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App {
    private final GameBoard ocean;
    private  boolean isFirstTime = true;

    public App() {
        ocean = new GameBoard();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        App huntApp = new App();
        while (true) {
            if (huntApp.isFirstTime) {
                huntApp.printHelp();
                huntApp.isFirstTime = false;
            }
            System.out.print("\nOur orders, sir: ");
            String order = scan.next();
            switch (order.toLowerCase().charAt(0)) {
            case 's':
                huntApp.ocean.keySonar();
                break;
            case 'b':
                if (huntApp.ocean.keyDropBomb()) {
                    System.out.println("Congratulation, sir! You completed the mission successfully!");
                    scan.close();
                    System.exit(0);
                }
                break;
            case 'h':
                huntApp.printHelp();
                break;
            case 'q':
                System.out.println("!! ABANDON SHIP - ABANDON SHIP !!");
                scan.close();
                System.exit(0);
                break;
            case 'a':
            case 'd':
            case 'w':
            case 'x':
                huntApp.ocean.keyMoveDestroyer(order);
                break;
            default:
                System.out.println("Sorry captain, I didn't understand (h = help)\n");
            }
        }
    }

    public void printHelp() {
        StringBuilder helpMessage = new StringBuilder(100);
        helpMessage.append("Commands are:\n")
            .append("s - Use (s)onar\n")
            .append("b - Drop a (b)omb\n")
            .append("\nMove destroyer:\n")
            .append("a - to the left\n")
            .append("d - to the right\n")
            .append("w - up\n")
            .append("x - down\n\n")
            .append("q - Abandon ship (quit game)\n");

        System.out.println(helpMessage.toString());
    }
}
