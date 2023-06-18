package me.simulation;

import java.util.*;
import java.util.concurrent.TimeUnit;

import me.simulation.game.Map;

public class ApplicationMain {
    /**
     * Main method to start the simulation application.
     *
     * @param args command-line arguments
     * @throws InterruptedException if the thread is interrupted
     */
    public static void main(String[] args) throws InterruptedException {
        int width, height, howMuchOrk, howMuchHuman, howMuchElf, howMuchChest, howMuchItem, howMuchPotion;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Rekomendowane wymiary mapy to od 12 do 24 dla obu parametrow");
        System.out.print("Podaj szerokość mapy:\u001B[32m");
        width = scanner.nextInt();
        System.out.print("\u001B[0mPodaj wysokość mapy:\u001B[32m");
        height = scanner.nextInt();
        System.out.print("\u001B[0m");

        Map map = new Map(width, height);

        map.placeObjectRandomly(5,10,8,5,5,5);
        map.mapDraw();// Initial display of the map
        map.printStats();
        TimeUnit.SECONDS.sleep(1);

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
