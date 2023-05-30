package me.simulation.game;

import me.simulation.equipments.Chest;
import me.simulation.equipments.Item;
import me.simulation.equipments.Potion;
import me.simulation.players.Champion;
import me.simulation.players.Elf;
import me.simulation.players.Human;
import me.simulation.players.Ork;

import java.util.ArrayList;

public class Map {
    public int width;
    public int height;
    ArrayList<ArrayList<Champion>> map;

    public Map(int width, int height){
        this.height = height;
        this.width = width;

        // Inicjalizacja mapy
        ArrayList<ArrayList<Champion>> map = new ArrayList<>(height);
        for (int i = 0 ; i < height; i++ ) {
            map.add(new ArrayList<Champion>(width));
            for (int j = 0 ; j < width; j++ ) {
                map.get(i).add(null);
            }
        }

        this.map = map;
    }

    public void placeObjectRandomly(int howMuch){
        for (int i = 0; i < howMuch; i++){

            int rand1 = (int) (Math.random() * (height));
            int rand2 = (int) (Math.random() * (width));

            if(i<5 && i>=0 && map.get(rand1).get(rand2)==null){
                map.get(rand1).add(rand2, new Ork("ork", 5, 20, 10, 1, 0,true, false, false, rand1, rand2));
            }
            if(i<10 && i>=5 && map.get(rand1).get(rand2)==null){
                map.get(rand1).add(rand2, new Human("human", 5, 20, 10, 1, 0,true, false, false, rand1, rand2));
            }
            if(i<15 && i>=10 && map.get(rand1).get(rand2)==null){
                map.get(rand1).add(rand2, new Elf("elf", 5, 20, 10, 1, 0,true, false, false, rand1, rand2));
            }
            if(i<20 && i>=15 && map.get(rand1).get(rand2)==null){
                map.get(rand1).add(rand2, new Chest("chest", rand1, rand2));
            }
            if(i<25 && i>=20 && map.get(rand1).get(rand2)==null){
                map.get(rand1).add(rand2, new Item("item", rand1, rand2));
            }
            if(i<30 && i>=25 && map.get(rand1).get(rand2)==null){
                map.get(rand1).add(rand2, new Potion("potion", rand1, rand2));
            }

        }

    }

    public void mapDraw(){
        System.out.print("╔");
        for (int i = 0 ; i < width; i++ ) {
            System.out.print("═══");
        }
        System.out.print("╗");
        System.out.println();

        for (int i = 0 ; i < height; i++ ) {
            System.out.print("║");
            for (int j = 0 ; j < width; j++ ) {
                if(map.get(i).get(j) != null){
                    if(map.get(i).get(j).race == "ork"){
                        System.out.print(" O ");
                    }
                    if(map.get(i).get(j).race == "human"){
                        System.out.print(" H ");
                    }
                    if(map.get(i).get(j).race == "elf"){
                        System.out.print(" E ");
                    }
                    if(map.get(i).get(j).type == "potion"){
                        System.out.print(" p ");
                    }
                    if(map.get(i).get(j).type == "item"){
                        System.out.print(" i ");
                    }
                    if(map.get(i).get(j).type == "chest"){
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
        for (int i = 0 ; i < width; i++ ) {
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
