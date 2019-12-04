package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    // User input
    Scanner input = new Scanner(System.in);

    // ArrayList Position
    ArrayList<Position> positions = new ArrayList<>();
    Position positionSubmarine;

    // Colours for background
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m";
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";

    //Colours for text
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String WHITE_BOLD = "\033[1;37m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String BLACK_BOLD = "\033[1;30m";

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";

    // Reset colour
    public static final String ANSI_RESET = "\u001B[0m";

    //Constant size for the map
    public final static int MAP_SIZE = 11;

    // Map template with grid size from variables (could be user input later on)
    //String[][] map = new String[MAP_SIZE][MAP_SIZE];
    ArrayList<Ship> ships = new ArrayList<>();


    // Constructor
    public Map() {
    }


    // Printing map with empty squares [ ]
    public void printEmptyMap(String map[][]) {

        // Prints the text and the line underneath the text
        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK +
                "                      OCEAN MAP                      " + ANSI_RESET);

        for (int line = 1; line < map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        // Initialize 2D matrix map
        for (int y = 1; y < map.length; y++) {
            for (int x = 1; x < map.length; x++) {
                map[x][y] = " ";
            }
        }

        // New line to structure the [ ] with the coordinates on the side
        System.out.println();

        // Initialises the empty squares as the game board [ ]
        for (int column = 1; column < map.length; column++) {
            String square = "";
            for (int row = 1; row < map.length; row++) {
                square += " [" + map[row][column] + "] ";
            }
            // Print the [ ]
            System.out.print(ANSI_BLUE + square + ANSI_RESET);

            // Print Y-coordinates on the side (column)
            System.out.println(ANSI_RED + "|" + column + "Y" + "|" + ANSI_RESET);
        }

        // Add line to separate the ocean map from the coordinates below
        for (int line = 1; line < map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }
        // Add new line to structure coordinates correctly below
        System.out.println();

        // Add this to center the coordinates with the [ ] in the map
        System.out.print(" ");

        // Adding X-coordinates
        for (int k = 1; k < map.length; k++) {
            System.out.print(ANSI_RED + "" + k + "X" + " | " + ANSI_RESET);
        }

        System.out.println("\n" + "\n" +
                YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + "S: SUBMARINE (1) " + ANSI_RESET + " " +
                BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "D: DESTROYER (1) " + ANSI_RESET + " " +
                GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "C: CRUISER (1) " + ANSI_RESET + " " +
                PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + "B: BATTLESHIP (1) " + ANSI_RESET + " " +
                CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c: CARRIER (2) " + ANSI_RESET
        );
        // Adding new line after the map prints
        System.out.println("\n");
    }


    // Add coordinates and ships to map
    public void addCoordinateToMap(String map[][], int xInput, int yInput, int size, String shipType) {
        for (int i = 0; i < size; i++) {
            for (int y = yInput; y <= yInput; y++) {
                y += i;
                for (int x = xInput; x <= xInput; x++) {

                    switch (shipType) {
                        case "submarine":
                            map[x][y] = YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + "S" + ANSI_RESET + ANSI_BLUE;
                            positionSubmarine = new Position(xInput, yInput);
                            positions.add(positionSubmarine);
                            break;

                        case "destroyer":
                            map[x][y] = BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "D" + ANSI_RESET + ANSI_BLUE;
                            break;

                        case "cruiser":
                            map[x][y] = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "C" + ANSI_RESET + ANSI_BLUE;
                            break;

                        case "battleship":
                            map[x][y] = PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + "B" + ANSI_RESET + ANSI_BLUE;
                            break;

                        case "carrier1":
                            map[x][y] = CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c" + ANSI_RESET + ANSI_BLUE;
                            break;

                        case "carrier2":
                            map[x][y] = CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c" + ANSI_RESET + ANSI_BLUE;
                            break;

                        case "battle":
                            map[x][y] = " ";
                            break;


                        default:
                            System.out.println("Invalid");
                            break;
                    }
                }
            }
        }
    }


    public void printPlayerMapShips(String map[][], int x, int y, int size, String shipType) {
        // Prints the text and the line underneath the text
        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK +
                "                      OCEAN MAP                      " + ANSI_RESET);

        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        // Adding coordinates from user input
        addCoordinateToMap(map,  x, y, size, shipType);

        // New line to structure the [ ] with the coordinates on the side
        System.out.println();

        // Initialises the empty squares as the game board [ ]
        for (int column = 1; column < map.length; column++) {
            String square = "";
            for (int row = 1; row < map.length; row++) {
                square += " [" + map[row][column] + "] ";
            }
            // Print the [ ]
            System.out.print(ANSI_BLUE + square + ANSI_RESET);

            // Print Y-coordinates on the side (column)
            System.out.println(ANSI_RED + "|" + column + "Y" + "|" + ANSI_RESET);
        }

        // Add line to separate the ocean map from the coordinates below
        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }
        // Add new line to structure coordinates correctly below
        System.out.println();

        // Add this to center the coordinates with the [ ] in the map
        System.out.print(" ");

        // Adding X-coordinates
        for (int k = 1; k < map.length; k++) {
            System.out.print(ANSI_RED + "" + k + "X" + " | " + ANSI_RESET);
        }

        System.out.println("\n" + "\n" +
                YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + "S: SUBMARINE (1) " + ANSI_RESET + " " +
                BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "D: DESTROYER (1) " + ANSI_RESET + " " +
                GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "C: CRUISER (1) " + ANSI_RESET + " " +
                PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + "B: BATTLESHIP (1) " + ANSI_RESET + " " +
                CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c: CARRIER (2) " + ANSI_RESET
        );

        // Adding new line after the map prints
        System.out.println("\n");
    }

    
    public void printBattle(String map[][],  int x, int y, String battle) {
        // Prints the text and the line underneath the text
        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK +
                "                      OCEAN MAP                      " + ANSI_RESET);

        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        // New line to structure the [ ] with the coordinates on the side
        System.out.println();

        // Initialises the empty squares as the game board [ ]
        for (int column = 1; column < map.length; column++) {
            String square = "";
            for (int row = 1; row < map.length; row++) {
                square += " [" + map[row][column] + "] ";
            }
            // Print the [ ]
            System.out.print(ANSI_BLUE + square + ANSI_RESET);

            // Print Y-coordinates on the side (column)
            System.out.println(ANSI_RED + "|" + column + "Y" + "|" + ANSI_RESET);
        }

        // Add line to separate the ocean map from the coordinates below
        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }
        // Add new line to structure coordinates correctly below
        System.out.println();

        // Add this to center the coordinates with the [ ] in the map
        System.out.print(" ");

        // Adding X-coordinates
        for (int k = 1; k < map.length; k++) {
            System.out.print(ANSI_RED + "" + k + "X" + " | " + ANSI_RESET);
        }

        System.out.println("\n" + "\n" +
                YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + "S: SUBMARINE (1) " + ANSI_RESET + " " +
                BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "D: DESTROYER (1) " + ANSI_RESET + " " +
                GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "C: CRUISER (1) " + ANSI_RESET + " " +
                PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + "B: BATTLESHIP (1) " + ANSI_RESET + " " +
                CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c: CARRIER (2) " + ANSI_RESET
        );
        // Adding new line after the map prints
        System.out.println("\n");
    }

}


