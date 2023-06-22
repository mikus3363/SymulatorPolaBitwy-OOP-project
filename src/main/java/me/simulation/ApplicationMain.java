package me.simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import me.simulation.game.Map;

/**
 * Main method to start the simulation application.
 */
public class ApplicationMain {
    /**
     * Main method to start the simulation application.
     *
     * This method allows the user to select different modes for the simulation, create a custom map,
     * and specify the number of mobs and items. It initializes a `Map` object based on the chosen mode
     * and proceeds with the simulation by calling various methods to display the map, perform the day cycle,
     * and print statistics.
     *
     * @param args command-line arguments
     * @throws InterruptedException if the thread is interrupted
     * @throws IllegalArgumentException if the input provided is not valid
     * @throws InputMismatchException if the input provided is of the wrong type
     */
    public static void main(String[] args) throws InterruptedException, IllegalArgumentException, InputMismatchException, FileNotFoundException {
        int menu, width, height, howMuchOrk, howMuchHuman, howMuchElf, howMuchChest, howMuchItem, howMuchPotion;
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔\n║ Wybierz rekomendowane tryby, lub stwóż własny:");
        System.out.println("║ Tryb mapa [24;16] \u001B[32m->\u001B[0m 0 (default)\n" +
                "║ Tryb mapa [13;13] \u001B[32m->\u001B[0m 1\n" +
                "║ Tryb mapa [8;8] \u001B[32m->\u001B[0m 2\n" +
                "║ Tryb mapa [własne] + ilosci mobów [własne] \u001B[32m->\u001B[0m 3\n" +
                "║ Tryb mapa [config] \u001B[32m->\u001B[0m 4\n" +
                "╚\n");
        System.out.print("PROMPT \u001B[32m->\u001B[0m ");

        Map map;
        switch (menu = scanner.nextInt()) {
            case 1 -> {
                map = new Map(13, 13);
                map.placeObjectRandomly(5, 9, 7, 4, 5, 5);
            }
            case 2 -> {
                map = new Map(8, 8);
                map.placeObjectRandomly(4, 8, 6, 3, 4, 4);
            }
            case 3 -> {
                System.out.println("Podaj szerokość mapy:\u001B[0m");
                System.out.print("PROMPT \u001B[32m->\u001B[0m ");
                width = scanner.nextInt();
                System.out.println("\u001B[0mPodaj wysokość mapy:\u001B[0m");
                System.out.print("PROMPT \u001B[32m->\u001B[0m ");
                height = scanner.nextInt();

                map = new Map(width, height);

                System.out.println("Podaj ilości mobów:\u001B[0m");
                System.out.println("\u001B[0mOrk:");
                System.out.print("PROMPT \u001B[32m->\u001B[0m ");
                howMuchOrk = scanner.nextInt();
                System.out.println("Elf:");
                System.out.print("PROMPT \u001B[32m->\u001B[0m ");
                howMuchElf = scanner.nextInt();
                System.out.println("Human:");
                System.out.print("PROMPT \u001B[32m->\u001B[0m ");
                howMuchHuman = scanner.nextInt();

                System.out.println("\u001B[0mPodaj ilości kitów:\u001B[0m");
                System.out.println("\u001B[0mChests:");
                System.out.print("PROMPT \u001B[32m->\u001B[0m ");
                howMuchChest = scanner.nextInt();
                System.out.println("Items:");
                System.out.print("PROMPT \u001B[32m->\u001B[0m ");
                howMuchItem = scanner.nextInt();
                System.out.println("Potions:");
                System.out.print("PROMPT \u001B[32m->\u001B[0m ");
                howMuchPotion = scanner.nextInt();
                System.out.print("\u001B[0m");

                map.placeObjectRandomly(howMuchOrk, howMuchHuman, howMuchElf, howMuchChest, howMuchItem, howMuchPotion);
            }
            case 4 -> {
                File config = new File("config.txt");
                Scanner odczyt = new Scanner(config);
                odczyt.nextLine();
                map = new Map(odczyt.nextInt(), odczyt.nextInt());
                map.placeObjectRandomly(odczyt.nextInt(), odczyt.nextInt(), odczyt.nextInt(), odczyt.nextInt(), odczyt.nextInt(), odczyt.nextInt());
            }
            default -> {
                map = new Map(24, 16);
                map.placeObjectRandomly(5, 10, 8, 5, 5, 5);
            }
        }


        map.mapDraw(); // Initial display of the map
        map.printStats();
        if(map.ifstop()){
            TimeUnit.MILLISECONDS.sleep(250);
        }
        else{
            TimeUnit.SECONDS.sleep(2);
        }


        System.out.println();
        while(map.ifend()) {
            Map.clear();
            System.out.println();
            map.dayCycle();
            map.mapDraw();
            map.printStats();
            TimeUnit.SECONDS.sleep(1);
        }

    }
}
