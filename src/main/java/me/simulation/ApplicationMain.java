package me.simulation;

import java.math.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import me.simulation.equipments.*;
import me.simulation.game.*;
import me.simulation.game.Map;
import me.simulation.players.*;

//test git
public class ApplicationMain {
    public static void main(String[] args) throws InterruptedException {
        // Teraz mozna dac rozny rozmiar mapy
        Scanner scanner = new Scanner(System.in);

        System.out.println("Rekomendowane wymiary mapy to od 12 do 24 dla obu parametrow");
        System.out.print("Podaj szerokość mapy:\u001B[32m");
        int width = scanner.nextInt();
        System.out.print("\u001B[0mPodaj wysokość mapy:\u001B[32m");
        int height = scanner.nextInt();
        System.out.print("\u001B[0m");

        Map map = new Map(width, height);

        map.placeObjectRandomly(5,10,8,5,5,5);
        map.mapDraw();//początkowe zaznajomienie użytkownika z mapą
        map.printStats();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("");
        while(map.ifend()) {
            Map.clear();
            System.out.println("");
            map.dayCycle();
            map.mapDraw();
            map.printStats();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}


