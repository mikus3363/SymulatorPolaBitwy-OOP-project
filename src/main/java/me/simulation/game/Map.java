package me.simulation.game;

import me.simulation.players.Champion;

import java.util.ArrayList;

public class Map {
    public int width;
    public int height;

    public Map(int width, int height){
        this.height = height;
        this.width = width;
    }
    public Map(ArrayList<ArrayList<Champion>> mapa){
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
                        System.out.print(" O ");
                    }
                    if(mapa.get(i).get(j).race == "human"){
                        System.out.print(" H ");
                    }
                    if(mapa.get(i).get(j).race == "elf"){
                        System.out.print(" E ");
                    }
                    if(mapa.get(i).get(j).race == "potion"){
                        System.out.print(" & ");
                    }
                    if(mapa.get(i).get(j).race == "item"){
                        System.out.print(" $ ");
                    }
                    if(mapa.get(i).get(j).race == "chest"){
                        System.out.print(" # ");
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

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
