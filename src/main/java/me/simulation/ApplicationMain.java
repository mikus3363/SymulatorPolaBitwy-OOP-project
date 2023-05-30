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

        map.placeObjectRandomly(30);
        map.mapDraw();

        ArrayList<ArrayList<Champion>> list = map.getMap();

        for (int i = 0 ; i < map.getHeight(); i++ ) {
            for (int j = 0 ; j < map.getWidth(); j++ ) {
                if(list.get(i).get(j) != null){
                    if(list.get(i).get(j).move == true){
                        list.get(i).get(j).move = false;
                        Champion champ = list.get(i).get(j);
                        list.get(i).remove(j);
                        list.get(i).add(j,null);
                        list.get(i).remove(j+1);
                        list.get(i).add(j+1,champ);

                    }
                }
            }
        }
        map.mapDraw();
    }

}


