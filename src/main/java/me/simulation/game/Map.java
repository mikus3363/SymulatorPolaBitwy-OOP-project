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
        System.out.print("╔");
        for (int i = 0 ; i < 12 ; i++ ) {
            System.out.print("═══");
        }
        System.out.print("╗");
        System.out.println();

        for (int i = 0 ; i < 12 ; i++ ) {
            System.out.print("║");
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
                    if(mapa.get(i).get(j).type == "potion"){
                        System.out.print(" p ");
                    }
                    if(mapa.get(i).get(j).type == "item"){
                        System.out.print(" i ");
                    }
                    if(mapa.get(i).get(j).type == "chest"){
                        System.out.print(" c ");
                    }
                }
                else {
                    System.out.print("   ");
                }
            }
            System.out.print("║");
            System.out.print("\n");
        }
        System.out.print("╚");
        for (int i = 0 ; i < 12 ; i++ ) {
            System.out.print("═══");
        }
        System.out.print("╝");
        System.out.println();
    }

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
