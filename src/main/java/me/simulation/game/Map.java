package me.simulation.game;

import me.simulation.equipments.Chest;
import me.simulation.equipments.Item;
import me.simulation.equipments.Potion;
import me.simulation.players.Champion;
import me.simulation.players.Elf;
import me.simulation.players.Human;
import me.simulation.players.Ork;

import java.util.ArrayList;
import java.util.Random;

public class Map {
    public int width;
    public int height;
    ArrayList<ArrayList<Champion>> map;
    public ArrayList<ArrayList<Champion>> getMap(){
        return map;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
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

    public void placeObjectRandomly(int howMuchOrk, int howMuchHuman, int howMuchElf, int howMuchChest, int howMuchItem, int howMuchPotion){
        int i;
        i = 0;
        while(i < howMuchOrk) {
            int rand1 = (int) (Math.random() * (height));
            int rand2 = (int) (Math.random() * (width));
            if(map.get(rand1).get(rand2)==null){
                map.get(rand1).set(rand2, new Ork("ork", 5, 20,20, 10, 1, 0,true, false, false, rand1, rand2));
                i++;
            }
        }

        i = 0;
        while(i < howMuchHuman) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if(map.get(rand1).get(rand2)==null){
                map.get(rand1).set(rand2, new Human("human", 5, 20,20, 10, 1, 0,true, false, false, rand1, rand2));
                i++;
            }
        }

        i = 0;
        while(i < howMuchElf) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if(map.get(rand1).get(rand2)==null){
                map.get(rand1).set(rand2, new Elf("elf", 5, 20,20, 10, 1, 0,true, false, false, rand1, rand2));
                i++;
            }
        }

        i = 0;
        while(i < howMuchChest) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if(map.get(rand1).get(rand2)==null){
                map.get(rand1).set(rand2, new Chest("chest", rand1, rand2));
                i++;
            }
        }

        i = 0;
        while(i < howMuchItem) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if(map.get(rand1).get(rand2)==null){
                map.get(rand1).set(rand2, new Item("item", rand1, rand2));
                i++;
            }
        }

        i = 0;
        while(i < howMuchPotion) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if(map.get(rand1).get(rand2)==null){
                map.get(rand1).set(rand2, new Potion("potion", rand1, rand2));
                i++;
            }
        }

    }

    public void mapDraw(){
        System.out.print("╔");
        for (int i = 0 ; i < map.size(); i++ ) {
            System.out.print("═══");
        }
        System.out.print("╗");
        System.out.println();

        for (ArrayList<Champion> champions : map) {
            System.out.print("║");
            for (Champion champion : champions) {
                if (champion != null) {
                    if (champion.race == "ork") {
                        System.out.print(" O ");
                    }
                    if (champion.race == "human") {
                        System.out.print(" H ");
                    }
                    if (champion.race == "elf") {
                        System.out.print(" E ");
                    }
                    if (champion.type == "potion") {
                        System.out.print(" p ");
                    }
                    if (champion.type == "item") {
                        System.out.print(" i ");
                    }
                    if (champion.type == "chest") {
                        System.out.print(" c ");
                    }
                } else {
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
    public void dayCycle(){
        ArrayList<ArrayList<Champion>> list = map;

        for (int i = 0 ; i < height; i++ ) {
            for (int j = 0 ; j < width; j++ ) {
                if(list.get(i).get(j) != null){
                    if(list.get(i).get(j).move){
                        list.get(i).get(j).move = false;
                        Random generator = new Random();
                        Champion champ = list.get(i).get(j);
                        int randommove = generator.nextInt(4);//zawsze sie rusza, warunki mało zdrowia zawsze 0
                        switch (randommove){
                            case 0://stój w miejscu
                                break;
                            case 1://ruch w prawo
                                if(j + 1 > 10){//ściana
                                    map.get(i).set(j,null);
                                    map.get(i).set(j - 1,champ);
                                }
                                else {
                                    map.get(i).set(j,null);
                                    map.get(i).set(j + 1,champ);
                                }
                                break;
                            case 2://ruch w lewo
                                if(j - 1 < 0){//ściana
                                    map.get(i).set(j,null);
                                    map.get(i).set(j + 1,champ);
                                }
                                else {
                                    map.get(i).set(j,null);
                                    map.get(i).set(j - 1,champ);
                                }
                                break;
                            case 3://ruch do góry
                                if(i - 1 < 0){//ściana
                                    map.get(i).set(j,null);
                                    map.get(i + 1).set(j,champ);
                                }
                                else {
                                    map.get(i).set(j,null);
                                    map.get(i - 1).set(j,champ);
                                }
                                break;
                            case 4://ruch w dół
                                if(i + 1 > 10){//ściana
                                    map.get(i).set(j,null);
                                    map.get(i - 1).set(j,champ);
                                }
                                else {
                                    map.get(i).set(j,null);
                                    map.get(i + 1).set(j,champ);
                                }
                                break;
                        }
                    }
                }
            }
        }
    }
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
