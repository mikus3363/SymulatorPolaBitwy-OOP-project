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
    int numberOfObjects = 0;
    int numberOfOrks = 0;
    int numberOfElfs = 0;
    int numberOfHumans = 0;
    int numberOfChests = 0;
    int numberOfItems = 0;
    int numberOfPotions = 0;
    int numberOfOrksKilled = 0;
    int numberOfElfsKilled = 0;
    int numberOfHumansKilled = 0;
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
        System.out.print("\u001B[30m╔");
        for (int i = 0 ; i < width; i++ ) {
            System.out.print("═══");
        }
        System.out.print("╗\u001B[0m");
        System.out.println();

        for (ArrayList<Champion> champions : map) {
            System.out.print("\u001B[30m║\u001B[0m");
            for (Champion champion : champions) {
                if (champion != null) {
                    if (champion.type == "ork") {
                        System.out.print("\u001B[32m O \u001B[0m");
                    }
                    if (champion.type == "human") {
                        System.out.print("\u001B[34m H \u001B[0m");
                    }
                    if (champion.type == "elf") {
                        System.out.print("\u001B[33m E \u001B[0m");
                    }
                    if (champion.type == "potion") {
                        System.out.print("\u001B[37m p \u001B[0m");
                    }
                    if (champion.type == "item") {
                        System.out.print("\u001B[37m i \u001B[0m");
                    }
                    if (champion.type == "chest") {
                        System.out.print("\u001B[37m c \u001B[0m");
                    }
                } else {
                    System.out.print("   ");
                }
            }
            System.out.print("\u001B[30m║\u001B[0m");
            System.out.print("\n");
        }
        System.out.print("\u001B[30m╚");
        for (int i = 0 ; i < width; i++ ) {
            System.out.print("═══");
        }
        System.out.print("╝\u001B[0m");
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
                            //case 0://stój w miejscu
                               // break;
                            case 0://ruch w prawo
                                if(j + 1 > width-1){//ściana
                                    if(map.get(i).get(j - 1) == null){
                                        map.get(i).set(j,null);
                                        map.get(i).set(j - 1,champ);
                                    }
                                }
                                else {
                                    if(map.get(i).get(j + 1) == null){
                                        map.get(i).set(j,null);
                                        map.get(i).set(j + 1,champ);
                                    }
                                }
                                break;
                            case 1://ruch w lewo
                                if(j - 1 < 0){//ściana
                                    if(map.get(i).get(j + 1) == null){
                                        map.get(i).set(j,null);
                                        map.get(i).set(j + 1,champ);
                                    }
                                }
                                else {
                                    if(map.get(i).get(j - 1) == null){
                                        map.get(i).set(j,null);
                                        map.get(i).set(j - 1,champ);
                                    }
                                }
                                break;
                            case 2://ruch do góry
                                if(i - 1 < 0){//ściana
                                    if(map.get(i+1).get(j) == null){
                                        map.get(i).set(j,null);
                                        map.get(i + 1).set(j,champ);
                                    }
                                }
                                else {
                                    if(map.get(i - 1).get(j) == null){
                                        map.get(i).set(j,null);
                                        map.get(i - 1).set(j,champ);
                                    }
                                }
                                break;
                            case 3://ruch w dół
                                if(i + 1 > height-1){//ściana
                                    if(map.get(i - 1).get(j) == null){
                                        map.get(i).set(j,null);
                                        map.get(i - 1).set(j,champ);
                                    }
                                }
                                else {
                                    if(map.get(i+1).get(j) == null){
                                        map.get(i).set(j,null);
                                        map.get(i + 1).set(j,champ);
                                    }
                                }
                                break;
                        }
                    }
                }
            }
        }
        for (int i = 0 ; i < height; i++ ) {
            for (int j = 0; j < width; j++) {
                if (list.get(i).get(j) != null) {
                    numberOfObjects++;
                    switch (list.get(i).get(j).type){
                        case "ork":
                            if(list.get(i).get(j).hp >= (list.get(i).get(j).maxhp / 3)) {
                                list.get(i).get(j).move = true;
                            }
                            numberOfOrks++;
                            break;
                        case "elf":
                            if(list.get(i).get(j).hp >= (list.get(i).get(j).maxhp / 3)) {
                                list.get(i).get(j).move = true;
                            }
                            numberOfElfs++;
                            break;
                        case "human":
                            if(list.get(i).get(j).hp >= (list.get(i).get(j).maxhp / 3)) {
                                list.get(i).get(j).move = true;
                            }
                            numberOfHumans++;
                            break;
                        case "chest":
                            list.get(i).get(j).move = false;
                            numberOfChests++;
                            break;
                        case "potion":
                            list.get(i).get(j).move = false;
                            numberOfPotions++;
                            break;
                        case "item":
                            list.get(i).get(j).move = false;
                            numberOfItems++;
                            break;

                    }
                }
            }
        }
    }

    public void printStats(){
        String wall = "\u001B[30m║\u001B[37m";
        System.out.println("\u001B[30m╔");
        System.out.println(wall+" ALL:"+numberOfObjects);
        System.out.println(wall+" \u001B[32mORK\u001B[37m:"+numberOfOrks+"\t\t Dead:"+numberOfOrksKilled);
        System.out.println(wall+" \u001B[33mELF\u001B[37m:"+numberOfElfs+"\t\t Dead:"+numberOfElfsKilled);
        System.out.println(wall+" \u001B[34mHUMAN\u001B[37m:"+numberOfHumans+"\t Dead:"+numberOfHumansKilled);
        System.out.println(wall+" CHEST:"+numberOfChests+"\t POTION:"+numberOfPotions+"\t ITEMS:"+numberOfItems);
        System.out.println("\u001B[30m╚\u001B[0m");
    }

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
