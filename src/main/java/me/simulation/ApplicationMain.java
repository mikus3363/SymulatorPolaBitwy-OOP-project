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
        Map map = new Map(24, 14);

        Scanner scanner = new Scanner(System.in);
        map.placeObjectRandomly(5,10,8,5,5,5);

        while(true) {
            map.dayCycle();
            map.mapDraw();
            map.printStats();
            //Map.clear();
            //System.out.println("Wciśnij ENTER aby kontynuować!");
            //String input = scanner.nextLine();
            TimeUnit.SECONDS.sleep(1);
        }
    }

}


