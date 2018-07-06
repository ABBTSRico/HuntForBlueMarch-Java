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
        StringBuffer helpMessage = new StringBuffer();
        helpMessage.append("Commands are:\n");
        helpMessage.append("s - Use (s)onar\n");
        helpMessage.append("b - Drop a (b)omb\n");
        helpMessage.append("\nMove destroyer:\n");
        helpMessage.append("a - to the left\n");
        helpMessage.append("d - to the right\n");
        helpMessage.append("w - up\n");
        helpMessage.append("x - down\n\n");
        helpMessage.append("q - Abandon ship (quit game)\n");

        System.out.println(helpMessage.toString());
    }
}
