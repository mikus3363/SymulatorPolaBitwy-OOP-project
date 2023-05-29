package me.simulation;

import java.util.*;
import me.simulation.equipments.*;
import me.simulation.game.Map;
import me.simulation.players.*;

//test git
public class ApplicationMain {
    public static void main(String[] args) {
        Ork ork1 = new Ork("ork", 5,20,10,1,0,false,false,2,8);
        Human human1 = new Human("human", 5,20,10,1,0,false,false,0,0);
        Elf elf1 = new Elf("elf", 5,20,10,1,0,false,false,1,2);
        ArrayList<ArrayList<Champion>> mapa = new ArrayList<>(12);


        for (int i = 0 ; i < 12 ; i++ ) {
            mapa.add(new ArrayList<Champion>(12));
            for (int j = 0 ; j < 12 ; j++ ) {
                mapa.get(i).add(null);
            }
        }

        mapa.get(ork1.x_index).add(ork1.y_index, ork1);
        mapa.get(human1.x_index).add(human1.y_index, human1);
        mapa.get(elf1.x_index).add(elf1.y_index, elf1);

        mapa.get(0).add(0, ork1); //gdy 2 champions są na jednym polu ten który był tam pierwszy przesuwa się o jedno pole w prawo, potyrzebne warunki
        mapa.get(2).add(4, human1);
        mapa.get(6).add(8, elf1);

        mapa.get(11).add(9, ork1);
        mapa.get(10).add(11, human1);
        mapa.get(7).add(0, elf1);

        mapa.get(3).add(4, ork1);
        mapa.get(2).add(7, human1);
        mapa.get(5).add(6, elf1);

        new Map(mapa);
    }
}


