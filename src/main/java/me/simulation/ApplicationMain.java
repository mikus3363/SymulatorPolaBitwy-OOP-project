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

        ArrayList<ArrayList<Champion>> list = map.getMap();

        for (int i = 0 ; i < map.getHeight(); i++ ) {
            for (int j = 0 ; j < map.getWidth(); j++ ) {
                if(list.get(i).get(j) != null){
                    if(list.get(i).get(j).move == true){
                        list.get(i).get(j).move = false;
                        Random generator = new Random();
                        Champion champ = list.get(i).get(j);
                        int randommove = generator.nextInt(4);//zawsze sie rusza, warunki mało zdrowia zawsze 0
                        switch (randommove){
                            case 0://stój w miejscu
                                break;
                            case 1://ruch w prawo
                                if(j + 1 > 10){//ściana

                                    list.get(i).remove(j - 1);
                                    list.get(i).add(j - 1,champ);
                                }
                                else {
                                    list.get(i).remove(j);
                                    list.get(i).add(j, null);
                                    list.get(i).remove(j + 1);
                                    list.get(i).add(j + 1, champ);
                                }
                                break;
                            case 2://ruch w lewo
                                if(j - 1 < 0){//ściana
                                    list.get(i).remove(j);
                                    list.get(i).add(j,null);
                                    list.get(i).remove(j + 1);
                                    list.get(i).add(j + 1,champ);
                                }
                                else {
                                    list.get(i).remove(j);
                                    list.get(i).add(j, null);
                                    list.get(i).remove(j - 1);
                                    list.get(i).add(j - 1, champ);
                                }
                                break;
                            case 3://ruch do góry
                                if(i - 1 < 0){//ściana
                                    list.get(i).remove(j);
                                    list.get(i).add(j,null);
                                    list.get(i + 1).remove(j);
                                    list.get(i + 1).add(j,champ);
                                }
                                else {
                                    list.get(i).remove(j);
                                    list.get(i).add(j, null);
                                    list.get(i - 1).remove(j);
                                    list.get(i - 1).add(j, champ);
                                }
                                break;
                            case 4://ruch w dół
                                if(i + 1 > 10){//ściana
                                    list.get(i).remove(j);
                                    list.get(i).add(j,null);
                                    list.get(i - 1).remove(j);
                                    list.get(i - 1).add(j,champ);
                                }
                                else {
                                    list.get(i).remove(j);
                                    list.get(i).add(j, null);
                                    list.get(i + 1).remove(j);
                                    list.get(i + 1).add(j, champ);
                                }
                                break;
                        }
                    }
                }
            }
        }
        map.mapDraw();
        System.out.println(map.getMap());
    }

}


