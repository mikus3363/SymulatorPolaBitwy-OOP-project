package me.simulation.game;

import me.simulation.equipments.Chest;
import me.simulation.equipments.Item;
import me.simulation.equipments.Potion;
import me.simulation.players.Champion;
import me.simulation.players.Elf;
import me.simulation.players.Human;
import me.simulation.players.Ork;

import java.util.*;

public class Map {
    private int numberOfObjects = 0;
    private int numberOfOrks = 0;
    private int numberOfElfs = 0;
    private int numberOfHumans = 0;
    private int numberOfChests = 0;
    private int numberOfItems = 0;
    private int numberOfPotions = 0;
    private int numberOfOrksKilled = 0;
    private int numberOfElfsKilled = 0;
    private int numberOfHumansKilled = 0;
    private List<String> announcements = new LinkedList<>();
    private final int width;
    private final int height;
    ArrayList<ArrayList<Champion>> map;

    public ArrayList<ArrayList<Champion>> getMap() {
        return map;
    }

    private int getWidth() {
        return width;
    }

    private int getHeight() {
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
                map.get(rand1).set(rand2, new Ork("ork", 1, 30, 30, 20, 1, 1, true, false, false, rand2, rand1,false));
                i++;
            }
        }

        i = 0;
        while (i < howMuchHuman) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if (map.get(rand1).get(rand2) == null) {
                map.get(rand1).set(rand2, new Human("human", 1, 15, 10, 10, 2, 5, true, false, false, rand2, rand1,false));
                i++;
            }
        }

        i = 0;
        while (i < howMuchElf) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if (map.get(rand1).get(rand2) == null) {
                map.get(rand1).set(rand2, new Elf("elf", 1, 20, 20, 15, 3, 3, true, false, false, rand2, rand1,false));
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
                // Zamieniłem IFY na Switcha dla lepszej wydajności
                if (champion != null) switch (champion.getType()) {
                    case "ork" -> System.out.print("\u001B[32m O \u001B[0m");
                    case "human" -> System.out.print("\u001B[34m H \u001B[0m");
                    case "elf" -> System.out.print("\u001B[33m E \u001B[0m");
                    case "potion" -> System.out.print("\u001B[37m p \u001B[0m");
                    case "chest" -> System.out.print("\u001B[37m c \u001B[0m");
                    case "item" -> System.out.print("\u001B[37m i \u001B[0m");
                }
                else {
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
                    if (list.get(i).get(j).getMove()) {
                        list.get(i).get(j).setMove(false);
                        Random generator = new Random();
                        Champion champ = list.get(i).get(j);
                        if(champ.getHp()>=(champ.getMaxHp()/3) || !champ.getRegeneration()) {//rusza się jeśli ma wiecej hp lub nie ma regena
                            int randommove = generator.nextInt(4);//zawsze sie rusza, warunki mało zdrowia zawsze 0
                            switch (randommove) {
                                //Na razie wylaczylem opcje stania w miejscu
                                // case 0: stój w miejscu
                                // break;
                                case 0 -> {//ruch w prawo
                                    if (j + 1 > width - 1) {//ściana
                                        toLeft(champ, map.get(i).get(j - 1), i, j);
                                    }
                                    // I dalej to samo
                                    else {
                                        toRight(champ, map.get(i).get(j + 1), i, j);
                                    }
                                }
                                case 1 -> {//ruch w lewo
                                    if (j - 1 < 0) {//ściana
                                        toRight(champ, map.get(i).get(j + 1), i, j);
                                    } else {
                                        toLeft(champ, map.get(i).get(j - 1), i, j);
                                    }
                                }
                                case 2 -> {//ruch do góry
                                    if (i - 1 < 0) {//ściana
                                        toUp(champ, map.get(i + 1).get(j), i, j);
                                    } else {
                                        toDown(champ, map.get(i - 1).get(j), i, j);
                                    }
                                }
                                case 3 -> {//ruch w dół
                                    if (i + 1 > height - 1) {//ściana
                                        toDown(champ, map.get(i - 1).get(j), i, j);
                                    } else {
                                        toUp(champ, map.get(i + 1).get(j), i, j);
                                    }
                                }
                            }
                        }
                        else{
                            champ.setRegeneration(true);
                            if(champ.getHp() >= ((champ.getMaxHp()/3)*2))//hp wzrośnie do 66% hp moze sie ruszac
                            {
                                champ.setRegeneration(false);
                            }
                            else {
                                champ.setHp(champ.getHp() + (champ.getMaxHp() / 6));//stoi i leczy sie o maxhp/6
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (list.get(i).get(j) != null) {
                    switch (list.get(i).get(j).getType()) {
                        case "ork", "elf", "human" -> {
                            list.get(i).get(j).setMove(true);
                        }
                        case "chest", "potion", "item" -> list.get(i).get(j).setMove(false);
                    }
                }
            }
        }
    }

    private void toRight(Champion champ, Champion opponent, int i, int j){
        if (opponent == null) {
            champ.newIndex(i, j + 1);
            map.get(i).set(j, null);
            map.get(i).set(j + 1, champ);
        } else {
            interaction(champ, opponent);
        }
    }

    private void toLeft(Champion champ, Champion opponent, int i, int j){
        if (opponent == null) {
            champ.newIndex(i, j - 1);
            map.get(i).set(j, null);
            map.get(i).set(j - 1, champ);
        } else {
            interaction(champ, opponent);
        }
    }

    private void toUp(Champion champ, Champion opponent, int i, int j){
        if (opponent == null) {
            champ.newIndex(i + 1, j);
            map.get(i).set(j, null);
            map.get(i + 1).set(j, champ);
        } else {
            interaction(champ, opponent);
        }
    }

    private void toDown(Champion champ, Champion opponent, int i, int j){
        if (opponent == null) {
            champ.newIndex(i - 1, j);
            map.get(i).set(j, null);
            map.get(i - 1).set(j, champ);
        } else {
            interaction(champ, opponent);
        }
    }

    public void printStats() {
        // wypisuje aktualne statystyki mapy
        // wraz z kolorami
        String wall = "\u001B[90m║\u001B[37m";
        System.out.println("\u001B[90m╔");
        int all = numberOfObjects-numberOfElfsKilled-numberOfHumansKilled-numberOfOrksKilled;
        System.out.println(wall + " ALL:" + all);
        System.out.println(wall + " \u001B[32mORK\u001B[37m:" + numberOfOrks + "\t\t Dead:" + numberOfOrksKilled);
        System.out.println(wall + " \u001B[33mELF\u001B[37m:" + numberOfElfs + "\t\t Dead:" + numberOfElfsKilled);
        System.out.println(wall + " \u001B[34mHUMAN\u001B[37m:" + numberOfHumans + "\t Dead:" + numberOfHumansKilled);
        System.out.println(wall + " CHEST:" + numberOfChests + "\t POTION:" + numberOfPotions + "\t ITEMS:" + numberOfItems);
        for(int i=0;i<announcements.toArray().length;i++)
        {
            System.out.println(wall+announcements.get(i));
        }
        System.out.println("\u001B[90m╚\u001B[0m");
        System.out.println("\u001B[90m╔");
        System.out.println(wall + " Event Table");
        System.out.println("\u001B[90m╚\u001B[0m");
        announcements.clear();
    }

    // Metoda interakcji która powinna się znaleść w Interface Interakcji
    private void interaction(Champion champ, Champion opponent) {
        // Metoda przyjmuje championa (obiekt ktory wykonuje krok) oraz opponenta (obiekt kory stoi w miejscu na kore chial by wejsc champ)
        switch (opponent.getType()) {
            // jezeli jest to inny ork, human, elf wykonuje sie FIGHT
            case "ork", "human", "elf" -> {
                if (champ.getType().equals(opponent.getType())) {
                    opponent.increaseLevel();
                } else {
                    // Prosta implementacjia metody FIGHT
                    // oraz aktualizacjia statow mapy
                    int iterator;
                    if(champ.getLuck()>opponent.getLuck()){
                        iterator = 0;
                    }
                    else if(champ.getLuck()<opponent.getLuck()){
                        iterator = 1;
                    }
                    else{
                        Random generator = new Random();
                        iterator = generator.nextInt(2);
                    }
                    while (champ.getHp() > 0 && opponent.getMaxHp() > 0) {
                        if (iterator % 2 == 1) {
                            if(!opponent.getShield()){//bez tarczy bije
                                opponent.takeDMG(champ.getStrength(), champ.getLevel(), champ.getRange(), champ.getLuck());
                            }
                            else{
                                opponent.setShield(false);
                            }
                            //z ratczą nic
                        } else {
                            if(champ.getSword())//ma miecz bije mocniej
                            {
                                champ.takeDMG(opponent.getStrength()+2, opponent.getLevel(), opponent.getRange()+2, opponent.getLuck());
                                champ.setSword(false);
                            }
                            else {//normalny cios
                                champ.takeDMG(opponent.getStrength(), opponent.getLevel(), opponent.getRange(), opponent.getLuck());
                            }

                        }
                        iterator++;
                    }

                    if (opponent.getHp() <= 0) {
                        mapDelete(champ.getY_index(), champ.getX_index());
                        champ.newIndex(opponent.getY_index(), opponent.getX_index());

                        mapDelete(opponent.getY_index(), opponent.getX_index());
                        map.get(opponent.getY_index()).set(opponent.getX_index(), champ);//zbicie przez wygranego

                        decreaseStatistics(opponent.getType());
                        announcements.add(" "+champ.getType()+" killed "+opponent.getType());
                    } else if (champ.getHp() <= 0) {
                        mapDelete(champ.getY_index(), champ.getX_index());

                        decreaseStatistics(champ.getType());
                        announcements.add(" "+opponent.getType()+" killed "+champ.getType());
                    }
                }
            }
            case "item", "chest", "potion" -> {
                // jezeli jest jakis KIT to mamy narazie doczynienia jedynie z "pochlonieciem" tego obiektu
                if(Objects.equals(opponent.getType(), "potion"))
                {
                    champ.setHp(champ.getMaxHp());
                    announcements.add(" "+champ.getType()+" drank potion");
                }
                else if(Objects.equals(opponent.getType(), "chest"))
                {
                    if(Chest.isMimicGenerate()) {
                        champ.setHp(champ.getMaxHp() / 10);//wpadł w pułapkę
                        announcements.add(" " + champ.getType() + " fell into the trap");
                    }
                    if(Chest.whatsInside()){
                        champ.setSword(true);//łapie miecz
                        announcements.add(" "+champ.getType()+" was equipped with sword");
                    }else {
                        champ.setShield(true);//łapie tarcze
                        announcements.add(" "+champ.getType()+" was equipped with shield");
                    }
                }
                else if(Objects.equals(opponent.getType(), "item"))
                {
                    Random generator = new Random();
                    int randommove = generator.nextInt(4);
                    switch (randommove)
                    {
                        case 0 -> {
                            champ.setHp(champ.getHp()+3);//dostaje życie
                            champ.setMaxHp(champ.getMaxHp()+3);//i max życie
                            announcements.add(" "+champ.getType()+" got a life boost");
                        }
                        case 1 -> {
                            champ.setLuck(champ.getLuck()+10);//dostaje szczęście
                            announcements.add(" "+champ.getType()+" got a luck boost");
                        }
                        case 2 -> {
                            champ.setStrength(champ.getStrength()+3);//dostaje siły
                            announcements.add(" "+champ.getType()+" got a strenght boost");
                        }
                        case 3 -> {
                            champ.setShield(true);//dostaje tarcze
                            announcements.add(" "+champ.getType()+" was equipped with shield");
                        }
                    }
                }
                mapDelete(champ.getY_index(), champ.getX_index());
                champ.newIndex(opponent.getY_index(), opponent.getX_index());
                mapDelete(opponent.getY_index(), opponent.getX_index());
                map.get(opponent.getY_index()).set(opponent.getX_index(), champ);//zbicie
                decreaseStatistics(opponent.getType());
            }
        }
    }

    private void decreaseStatistics(String type){
        switch (type) {
            case "ork" -> {
                numberOfOrks--;
                numberOfOrksKilled++;
            }
            case "human" -> {
                numberOfHumans--;
                numberOfHumansKilled++;
            }
            case "elf" -> {
                numberOfElfs--;
                numberOfElfsKilled++;
            }
            case "item" -> numberOfItems--;
            case "chest" -> numberOfChests--;
            case "potion" -> numberOfPotions--;
            default -> {
            }
        }
    }

    // To najzwyczajniej w świecie usuwa obiekt z macierzy
    private void mapDelete(int yIndex, int xIndex) {
        map.get(yIndex).set(xIndex, null);
    }

    // To powinno w przyszłości czyścić konsole
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                //noinspection deprecation
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
            System.out.println(wall+" \u001B[32mOrki podbiły pole bitwy!");
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