package me.simulation;

import java.util.*;
import me.simulation.equipments.*;
import me.simulation.game.Map;
import me.simulation.players.*;

//test git
public class ApplicationMain {
    public static void main(String[] args) {
        Ork ork1 = new Ork("ork", 5,20,10,1,0,false,false,2,3);
        Human human1 = new Human("human", 5,20,10,1,0,false,false,2,3);
        Elf elf1 = new Elf("elf", 5,20,10,1,0,false,false,2,3);
        ArrayList<ArrayList<Champion>> mapa = new ArrayList<>(12);


        for (int i = 0 ; i < 12 ; i++ ) {
            mapa.add(new ArrayList<Champion>(12));
            for (int j = 0 ; j < 12 ; j++ ) {
                mapa.get(i).add(null);
            }
        }

        mapa.get(0).add(0, ork1);
        mapa.get(0).add(1, human1);
        mapa.get(0).add(9, elf1);

        mapa.get(8).add(3, ork1);
        mapa.get(2).add(4, human1);
        mapa.get(6).add(8, elf1);

        mapa.get(11).add(9, ork1);
        mapa.get(10).add(11, human1);
        mapa.get(7).add(0, elf1);

        mapa.get(3).add(4, ork1);
        mapa.get(2).add(7, human1);
        mapa.get(5).add(6, elf1);

        System.out.print("_");
        for (int i = 0 ; i < 12 ; i++ ) {
            System.out.print("___");
        }
        System.out.print("_");
        System.out.println();

        for (int i = 0 ; i < 12 ; i++ ) {
            System.out.print("|");
            for (int j = 0 ; j < 12 ; j++ ) {
                if(mapa.get(i).get(j) != null){
                    if(mapa.get(i).get(j).race == "ork"){
                        System.out.print(" + ");
                    }
                    if(mapa.get(i).get(j).race == "human"){
                        System.out.print(" * ");
                    }
                    if(mapa.get(i).get(j).race == "elf"){
                        System.out.print(" - ");
                    }
                }
                else {
                    System.out.print("   ");
                }
            }
            System.out.print("|");
            System.out.print("\n");
        }
        System.out.print("_");
        for (int i = 0 ; i < 12 ; i++ ) {
            System.out.print("___");
        }
        System.out.print("_");
        System.out.println();

    }
}


