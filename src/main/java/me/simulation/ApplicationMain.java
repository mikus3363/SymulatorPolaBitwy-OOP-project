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
        Map map = new Map(12, 12);

        map.placeObjectRandomly(5,5,5,5,5,5);
        map.mapDraw();
        map.dayCycle();
        map.mapDraw();
        System.out.println(map.getMap());
    }

}


