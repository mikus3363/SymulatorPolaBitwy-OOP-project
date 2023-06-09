package me.simulation;

import java.math.*;
import java.util.*;
import me.simulation.equipments.*;
import me.simulation.game.*;
import me.simulation.game.Map;
import me.simulation.players.*;

//test git
public class ApplicationMain {
    public static void main(String[] args) {
        // Teraz mozna dac rozny rozmiar mapy
        Map map = new Map(24, 14);

        Scanner scanner = new Scanner(System.in);
        map.placeObjectRandomly(5,5,5,5,5,5);
        map.mapDraw();

        while(true) {
            map.dayCycle();
            map.mapDraw();
            map.printStats();
            System.out.println("Wciśnij ENTER aby kontynuować!");
            String input = scanner.nextLine();
            break;
        }
    }

}


