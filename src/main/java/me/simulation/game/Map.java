package me.simulation.game;

public class Map {
    public int width;
    public int height;

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
