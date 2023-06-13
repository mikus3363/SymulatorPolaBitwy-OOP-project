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

    public ArrayList<ArrayList<Champion>> getMap() {
        return map;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map(int width, int height) {
        this.height = height;
        this.width = width;

        // Inicjalizacja mapy
        ArrayList<ArrayList<Champion>> map = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            map.add(new ArrayList<Champion>(width));
            for (int j = 0; j < width; j++) {
                map.get(i).add(null);
            }
        }

        this.map = map;
    }

    public void placeObjectRandomly(int howMuchOrk, int howMuchHuman, int howMuchElf, int howMuchChest, int howMuchItem, int howMuchPotion) {
        numberOfObjects = howMuchOrk + howMuchHuman + howMuchElf + howMuchChest + howMuchItem + howMuchPotion;
        numberOfOrks = howMuchOrk;
        numberOfHumans = howMuchHuman;
        numberOfElfs = howMuchElf;
        numberOfPotions = howMuchPotion;
        numberOfChests = howMuchChest;
        numberOfItems = howMuchItem;

        int i;
        i = 0;
        while (i < howMuchOrk) {
            int rand1 = (int) (Math.random() * (height));
            int rand2 = (int) (Math.random() * (width));
            if (map.get(rand1).get(rand2) == null) {
                map.get(rand1).set(rand2, new Ork("ork", 1, 30, 30, 20, 1, 1, true, false, false, rand2, rand1));
                i++;
            }
        }

        i = 0;
        while (i < howMuchHuman) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if (map.get(rand1).get(rand2) == null) {
                map.get(rand1).set(rand2, new Human("human", 1, 15, 10, 10, 2, 5, true, false, false, rand2, rand1));
                i++;
            }
        }

        i = 0;
        while (i < howMuchElf) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if (map.get(rand1).get(rand2) == null) {
                map.get(rand1).set(rand2, new Elf("elf", 1, 20, 20, 15, 3, 3, true, false, false, rand2, rand1));
                i++;
            }
        }

        i = 0;
        while (i < howMuchChest) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if (map.get(rand1).get(rand2) == null) {
                map.get(rand1).set(rand2, new Chest("chest", rand2, rand1));
                i++;
            }
        }

        i = 0;
        while (i < howMuchItem) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if (map.get(rand1).get(rand2) == null) {
                map.get(rand1).set(rand2, new Item("item", rand2, rand1));
                i++;
            }
        }

        i = 0;
        while (i < howMuchPotion) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if (map.get(rand1).get(rand2) == null) {
                map.get(rand1).set(rand2, new Potion("potion", rand2, rand1));
                i++;
            }
        }

    }

    public void mapDraw() {
        System.out.print("\u001B[90m╔");
        for (int i = 0; i < width; i++) {
            System.out.print("═══");
        }
        System.out.print("╗\u001B[0m");
        System.out.println();

        for (ArrayList<Champion> champions : map) {
            System.out.print("\u001B[90m║\u001B[0m");
            for (Champion champion : champions) {
                if (champion != null) {
                    // Zamieniłem IFY na Switcha dla lepszej wydajności
                    switch (champion.type) {
                        case "ork":
                            System.out.print("\u001B[32m O \u001B[0m");
                            break;
                        case "human":
                            System.out.print("\u001B[34m H \u001B[0m");
                            break;
                        case "elf":
                            System.out.print("\u001B[33m E \u001B[0m");
                            break;
                        case "potion":
                            System.out.print("\u001B[37m p \u001B[0m");
                            break;
                        case "chest":
                            System.out.print("\u001B[37m c \u001B[0m");
                            break;
                        case "item":
                            System.out.print("\u001B[37m i \u001B[0m");
                            break;
                    }
                } else {
                    System.out.print("   ");
                }
            }
            System.out.print("\u001B[90m║\u001B[0m");
            System.out.print("\n");
        }
        System.out.print("\u001B[90m╚");
        for (int i = 0; i < width; i++) {
            System.out.print("═══");
        }
        System.out.print("╝\u001B[0m");
        System.out.println();
    }

    public void dayCycle() {
        ArrayList<ArrayList<Champion>> list = map;

        // Metoda odpowiedzialna za poruszanie sie obiektow
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (list.get(i).get(j) != null) {
                    if (list.get(i).get(j).move) {
                        list.get(i).get(j).move = false;
                        Random generator = new Random();
                        Champion champ = list.get(i).get(j);
                        int randommove = generator.nextInt(4);//zawsze sie rusza, warunki mało zdrowia zawsze 0
                        Champion opponent;
                        switch (randommove) {
                            //Na razie wylaczylem opcje stania w miejscu
                            //case 0://stój w miejscu
                            // break;
                            case 0://ruch w prawo
                                if (j + 1 > width - 1) {//ściana
                                    if ((opponent = map.get(i).get(j - 1)) == null) { // <- TO jest jednoczeście przypisanie do opponent oraz sprawdzenie warunku
                                        champ.newIndex(i, j - 1);
                                        map.get(i).set(j, null);
                                        map.get(i).set(j - 1, champ);
                                    } else {
                                        // Jezeli miejsce jest zajete to miedzy tymi dwoma obiektami dochodzi do interakcji
                                        interaction(champ, opponent);
                                    }
                                }
                                // I dalej to samo
                                else {
                                    if ((opponent = map.get(i).get(j + 1)) == null) {
                                        champ.newIndex(i, j + 1);
                                        map.get(i).set(j, null);
                                        map.get(i).set(j + 1, champ);
                                    } else {
                                        interaction(champ, opponent);
                                    }
                                }
                                break;
                            case 1://ruch w lewo
                                if (j - 1 < 0) {//ściana
                                    if ((opponent = map.get(i).get(j + 1)) == null) {
                                        champ.newIndex(i, j + 1);
                                        map.get(i).set(j, null);
                                        map.get(i).set(j + 1, champ);
                                    } else {
                                        interaction(champ, opponent);
                                    }
                                } else {
                                    if ((opponent = map.get(i).get(j - 1)) == null) {
                                        champ.newIndex(i, j - 1);
                                        map.get(i).set(j, null);
                                        map.get(i).set(j - 1, champ);
                                    } else {
                                        interaction(champ, opponent);
                                    }
                                }
                                break;
                            case 2://ruch do góry
                                if (i - 1 < 0) {//ściana
                                    if ((opponent = map.get(i + 1).get(j)) == null) {
                                        champ.newIndex(i + 1, j);
                                        map.get(i).set(j, null);
                                        map.get(i + 1).set(j, champ);
                                    } else {
                                        interaction(champ, opponent);
                                    }
                                } else {
                                    if ((opponent = map.get(i - 1).get(j)) == null) {
                                        champ.newIndex(i - 1, j);
                                        map.get(i).set(j, null);
                                        map.get(i - 1).set(j, champ);
                                    } else {
                                        interaction(champ, opponent);
                                    }
                                }
                                break;
                            case 3://ruch w dół
                                if (i + 1 > height - 1) {//ściana
                                    if ((opponent = map.get(i - 1).get(j)) == null) {
                                        champ.newIndex(i - 1, j);
                                        map.get(i).set(j, null);
                                        map.get(i - 1).set(j, champ);
                                    } else {
                                        interaction(champ, opponent);
                                    }
                                } else {
                                    if ((opponent = map.get(i + 1).get(j)) == null) {
                                        champ.newIndex(i + 1, j);
                                        map.get(i).set(j, null);
                                        map.get(i + 1).set(j, champ);
                                    } else {
                                        interaction(champ, opponent);
                                    }
                                }
                                break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (list.get(i).get(j) != null) {
                    switch (list.get(i).get(j).type) {
                        case "ork", "elf", "human":
                            if (list.get(i).get(j).hp >= (list.get(i).get(j).maxhp / 3)) {
                                list.get(i).get(j).move = true;
                            }
                            break;
                        case "chest", "potion", "item":
                            list.get(i).get(j).move = false;
                            break;

                    }
                }
            }
        }
    }

    public void printStats() {
        // wypisuje aktualne statystyki mapy
        // wraz z kolorami
        String wall = "\u001B[90m║\u001B[37m";
        System.out.println("\u001B[90m╔");
        System.out.println(wall + " ALL:" + numberOfObjects);
        System.out.println(wall + " \u001B[32mORK\u001B[37m:" + numberOfOrks + "\t\t Dead:" + numberOfOrksKilled);
        System.out.println(wall + " \u001B[33mELF\u001B[37m:" + numberOfElfs + "\t\t Dead:" + numberOfElfsKilled);
        System.out.println(wall + " \u001B[34mHUMAN\u001B[37m:" + numberOfHumans + "\t Dead:" + numberOfHumansKilled);
        System.out.println(wall + " CHEST:" + numberOfChests + "\t POTION:" + numberOfPotions + "\t ITEMS:" + numberOfItems);
        System.out.println("\u001B[90m╚\u001B[0m");
        System.out.println("\u001B[90m╔");
        System.out.println(wall + " Event Table");
        System.out.println("\u001B[90m╚\u001B[0m");
    }

    // Metoda interakcji która powinna się znaleść w Interface Interakcji
    public void interaction(Champion champ, Champion opponent) {
        // Metoda przyjmuje championa (obiekt ktory wykonuje krok) oraz opponenta (obiekt kory stoi w miejscu na kore chial by wejsc champ)
        switch (opponent.type) {
            // jezeli jest to inny ork, human, elf wykonuje sie FIGHT
            case "ork", "human", "elf":
                if (champ.type == opponent.type) {
                    //champ.level++;
                    opponent.level++;
                } else {
                    // Prosta implementacjia metody FIGHT
                    // oraz aktualizacjia statow mapy
                    int iterator = 1;
                    while (champ.hp>0 & opponent.hp>0){
                        if(iterator%2==1){
                            opponent.hp -= (champ.strength*champ.level)/2;
                        } else {
                            champ.hp -= (opponent.strength*opponent.level)/2;
                        }
                        iterator++;
                    }

                    if(opponent.hp<=0){
                        mapDelete(champ.y_index, champ.x_index);
                        champ.newIndex(opponent.y_index, opponent.x_index);
                        mapDelete(opponent.y_index, opponent.x_index);
                        map.get(opponent.y_index).set(opponent.x_index, champ);//zbicie przez wygranego
                        switch (opponent.type) {
                            case "ork":
                                numberOfOrks--;
                                numberOfOrksKilled++;
                                break;
                            case "human":
                                numberOfHumans--;
                                numberOfHumansKilled++;
                                break;
                            case "elf":
                                numberOfElfs--;
                                numberOfElfsKilled++;
                                break;
                        }
                    } else if(champ.hp<=0) {
                        mapDelete(champ.y_index, champ.x_index);
                        switch (champ.type) {
                            case "ork":
                                numberOfOrks--;
                                numberOfOrksKilled++;
                                break;
                            case "human":
                                numberOfHumans--;
                                numberOfHumansKilled++;
                                break;
                            case "elf":
                                numberOfElfs--;
                                numberOfElfsKilled++;
                                break;
                        }
                    }
                }
                break;
            case "item", "chest", "potion":
                // jezeli jest jakis KIT to mamy narazie doczynienia jedynie z "pochlonieciem" tego obiektu
                mapDelete(champ.y_index, champ.x_index);
                champ.newIndex(opponent.y_index, opponent.x_index);
                mapDelete(opponent.y_index, opponent.x_index);
                map.get(opponent.y_index).set(opponent.x_index, champ);
                switch (opponent.type) {
                    case "item":
                        numberOfItems--;
                        break;
                    case "chest":
                        numberOfChests--;
                        break;
                    case "potion":
                        numberOfPotions--;
                        break;
                }
                break;
        }
    }

    // To najzwyczajniej w świecie usuwa obiekt z macierzy
    public void mapDelete(int yIndex, int xIndex) {
        map.get(yIndex).set(xIndex, null);
    }

    // To powinno w przyszłości czyścić konsole
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean ifend() {
        String wall = "\u001B[90m║\u001B[37m";
        if (numberOfElfs == 0 && numberOfHumans == 0) {
            System.out.println("\u001B[90m╔");
            System.out.println(wall+" \u001B[32mpodbiły pole bitwy!");
            System.out.println("\u001B[90m╚\u001B[0m");
            return false;
        }
        if (numberOfElfs == 0 && numberOfOrks == 0) {
            System.out.println("\u001B[90m╔");
            System.out.println(wall+" \u001B[34mLudzie podbili pole bitwy!");
            System.out.println("\u001B[90m╚\u001B[0m");
            return false;
        }
        if (numberOfOrks == 0 && numberOfHumans == 0) {
            System.out.println("\u001B[90m╔");
            System.out.println(wall+" \u001B[33mElfy podbiły pole bitwy!");
            System.out.println("\u001B[90m╚\u001B[0m");
            return false;
        }
        return true;

    }
}