package me.simulation.game;

import me.simulation.equipments.*;
import me.simulation.players.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Represents a game map with champions and objects.
 */
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
    private int dayCyclesPassed = 0;
    ArrayList<ArrayList<Champion>> map;

    /**
     * Get the map of champions.
     *
     * @return The map of champions.
     */
    public ArrayList<ArrayList<Champion>> getMap() {
        return map;
    }

    /**
     * Get the width of the map.
     *
     * @return The width of the map.
     */
    private int getWidth() {
        return width;
    }

    /**
     * Get the height of the map.
     *
     * @return The height of the map.
     */
    private int getHeight() {
        return height;
    }

    /**
     * Constructs a new Map with the specified width and height.
     *
     * @param width  The width of the map.
     * @param height The height of the map.
     */
    public Map(int width, int height) {
        this.height = height;
        this.width = width;

        // Initialize the map
        ArrayList<ArrayList<Champion>> map = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            map.add(new ArrayList<Champion>(width));
            for (int j = 0; j < width; j++) {
                map.get(i).add(null);
            }
        }

        this.map = map;
    }
    /**
     * Randomly places objects on the map, such as champions, chests, items, and potions.
     *
     * @param howMuchOrk   The number of Ork objects to place on the map.
     * @param howMuchHuman The number of Human objects to place on the map.
     * @param howMuchElf   The number of Elf objects to place on the map.
     * @param howMuchChest The number of Chest objects to place on the map.
     * @param howMuchItem  The number of Item objects to place on the map.
     * @param howMuchPotion The number of Potion objects to place on the map.
     */
    public void placeObjectRandomly(int howMuchOrk, int howMuchHuman, int howMuchElf, int howMuchChest, int howMuchItem, int howMuchPotion) {
        numberOfObjects = howMuchOrk + howMuchHuman + howMuchElf + howMuchChest + howMuchItem + howMuchPotion;
        numberOfOrks = howMuchOrk;
        numberOfHumans = howMuchHuman;
        numberOfElfs = howMuchElf;
        numberOfPotions = howMuchPotion;
        numberOfChests = howMuchChest;
        numberOfItems = howMuchItem;

        int i;

        // Place Ork objects randomly on the map
        i = 0;
        while (i < howMuchOrk) {
            int rand1 = (int) (Math.random() * (height));
            int rand2 = (int) (Math.random() * (width));
            if (map.get(rand1).get(rand2) == null) {
                map.get(rand1).set(rand2, new Ork("ork", 1, 30, 30, 20, 1, 1, true, false, false, rand2, rand1,false));
                i++;
            }
        }

        // Place Human objects randomly on the map
        i = 0;
        while (i < howMuchHuman) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if (map.get(rand1).get(rand2) == null) {
                map.get(rand1).set(rand2, new Human("human", 1, 15, 10, 10, 2, 5, true, false, false, rand2, rand1,false));
                i++;
            }
        }

        // Place Elf objects randomly on the map
        i = 0;
        while (i < howMuchElf) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if (map.get(rand1).get(rand2) == null) {
                map.get(rand1).set(rand2, new Elf("elf", 1, 20, 20, 15, 6, 3, true, false, false, rand2, rand1,false));
                i++;
            }
        }

        // Place Chest objects randomly on the map
        i = 0;
        while (i < howMuchChest) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if (map.get(rand1).get(rand2) == null) {
                map.get(rand1).set(rand2, new Chest("chest", rand2, rand1));
                i++;
            }
        }

        // Place Item objects randomly on the map
        i = 0;
        while (i < howMuchItem) {
            int rand1 = (int) (Math.random() * (height - 1));
            int rand2 = (int) (Math.random() * (width - 1));
            if (map.get(rand1).get(rand2) == null) {
                map.get(rand1).set(rand2, new Item("item", rand2, rand1));
                i++;
            }
        }

        // Place Potion objects randomly on the map
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

    /**
     * Draws the game map with champions and objects.
     */
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
                // Draw the corresponding symbol based on the champion's type
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

    /**
     * Simulates a day cycle by moving objects on the map.
     * The method handles the movement and behavior of champions.
     * It also manages the regeneration of champions' health points.
     */
    public void dayCycle() {
        ArrayList<ArrayList<Champion>> list = map;

        // Movement of objects
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (list.get(i).get(j) != null) {
                    if (list.get(i).get(j).getMove()) {
                        list.get(i).get(j).setMove(false);
                        Random generator = new Random();
                        Champion champ = list.get(i).get(j);
                        if(champ.getHp()>=(champ.getMaxHp()/3) || !champ.getRegeneration()) {
                            // Move if the champion has sufficient health or no regeneration
                            int randommove = generator.nextInt(4);
                            switch (randommove) {
                                case 0 -> {// Move right
                                    if (j + 1 > width - 1) { // wall
                                        toLeft(champ, map.get(i).get(j - 1), i, j);
                                    }
                                    else {
                                        toRight(champ, map.get(i).get(j + 1), i, j);
                                    }
                                }
                                case 1 -> {// Move left
                                    if (j - 1 < 0) { // wall
                                        toRight(champ, map.get(i).get(j + 1), i, j);
                                    } else {
                                        toLeft(champ, map.get(i).get(j - 1), i, j);
                                    }
                                }
                                case 2 -> {// Move up
                                    if (i - 1 < 0) { // wall
                                        toUp(champ, map.get(i + 1).get(j), i, j);
                                    } else {
                                        toDown(champ, map.get(i - 1).get(j), i, j);
                                    }
                                }
                                case 3 -> {// Move down
                                    if (i + 1 > height - 1) { // wall
                                        toDown(champ, map.get(i - 1).get(j), i, j);
                                    } else {
                                        toUp(champ, map.get(i + 1).get(j), i, j);
                                    }
                                }
                            }
                        }
                        else{
                            // Regenerate health points if the champion's health is low
                            champ.setRegeneration(true);
                            if(champ.getHp() >= ((champ.getMaxHp()/3)*2))
                            {
                                champ.setRegeneration(false);
                            }
                            else {
                                champ.setHp(champ.getHp() + (champ.getMaxHp() / 6));
                            }
                        }
                    }
                }
            }
        }
        // Set movement flags for champions and non-champions
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
        dayCyclesPassed++;
    }

    /**
     * Moves the champion to the right on the map or triggers an interaction with an opponent.
     *
     * @param champ    The champion to be moved.
     * @param opponent The opponent champion at the target position.
     * @param i        The current row index of the champion.
     * @param j        The current column index of the champion.
     */
    private void toRight(Champion champ, Champion opponent, int i, int j){
        if (opponent == null) {
            champ.newIndex(i, j + 1);
            map.get(i).set(j, null);
            map.get(i).set(j + 1, champ);
        } else {
            interaction(champ, opponent);
        }
    }

    /**
     * Moves the champion to the left on the map or triggers an interaction with an opponent.
     *
     * @param champ    The champion to be moved.
     * @param opponent The opponent champion at the target position.
     * @param i        The current row index of the champion.
     * @param j        The current column index of the champion.
     */
    private void toLeft(Champion champ, Champion opponent, int i, int j){
        if (opponent == null) {
            champ.newIndex(i, j - 1);
            map.get(i).set(j, null);
            map.get(i).set(j - 1, champ);
        } else {
            interaction(champ, opponent);
        }
    }

    /**
     * Moves the champion upward on the map or triggers an interaction with an opponent.
     *
     * @param champ    The champion to be moved.
     * @param opponent The opponent champion at the target position.
     * @param i        The current row index of the champion.
     * @param j        The current column index of the champion.
     */
    private void toUp(Champion champ, Champion opponent, int i, int j){
        if (opponent == null) {
            champ.newIndex(i + 1, j);
            map.get(i).set(j, null);
            map.get(i + 1).set(j, champ);
        } else {
            interaction(champ, opponent);
        }
    }

    /**
     * Moves the champion downward on the map or triggers an interaction with an opponent.
     *
     * @param champ    The champion to be moved.
     * @param opponent The opponent champion at the target position.
     * @param i        The current row index of the champion.
     * @param j        The current column index of the champion.
     */
    private void toDown(Champion champ, Champion opponent, int i, int j){
        if (opponent == null) {
            champ.newIndex(i - 1, j);
            map.get(i).set(j, null);
            map.get(i - 1).set(j, champ);
        } else {
            interaction(champ, opponent);
        }
    }

    /**
     * Prints the current statistics of the map, including colors.
     * The statistics include the number of all objects on the map,
     * the number of orks and their kills, the number of elves and their kills,
     * the number of humans and their kills, the number of chests, potions, and items.
     * It also prints any announcements stored in the announcements list.
     * After printing the statistics and announcements, the announcements list is cleared.
     */
    public void printStats() {
        // Prints the header of the statistics with color-coded walls
        String wall = "\u001B[90m║\u001B[37m";
        System.out.println("\u001B[90m╔");

        // Calculates the number of remaining objects on the map
        int all = numberOfObjects-numberOfElfsKilled-numberOfHumansKilled-numberOfOrksKilled;

        // Prints the total number of remaining objects
        System.out.println(wall + " ALL:" + all);

        // Prints the number of orks and their kills
        System.out.println(wall + " \u001B[32mORK\u001B[37m:" + numberOfOrks + "\t\t Dead:" + numberOfOrksKilled);

        // Prints the number of elves and their kills
        System.out.println(wall + " \u001B[33mELF\u001B[37m:" + numberOfElfs + "\t\t Dead:" + numberOfElfsKilled);

        // Prints the number of humans and their kills
        System.out.println(wall + " \u001B[34mHUMAN\u001B[37m:" + numberOfHumans + "\t Dead:" + numberOfHumansKilled);

        // Prints the number of chests, potions, and items
        System.out.println(wall + " CHEST:" + numberOfChests + "\t POTION:" + numberOfPotions + "\t ITEMS:" + numberOfItems);

        System.out.println("\u001B[90m╚\u001B[0m");

        // Prints the header for the announcements section
        System.out.println("\u001B[90m╔");

        // Prints each announcement stored in the announcements list
        for(int i=0;i<announcements.toArray().length;i++)
        {
            System.out.println(wall+" -> "+announcements.get(i));
        }
        System.out.println("\u001B[90m╚\u001B[0m");

        // Clears the announcements list
        announcements.clear();
    }

    /**
     * Performs an interaction between the champion and the opponent on the map.
     * The method takes a champion object (the one performing the action) and an opponent object (the one occupying the champion's desired location).
     *
     * If the opponent is another orc, human, or elf, a fight occurs. The champion and opponent engage in combat.
     * If the champion and opponent have the same type, the opponent's level is increased.
     * Otherwise, a simple fight implementation takes place, updating the map's statistics.
     * The outcome of the fight depends on luck and other factors.
     *
     * If the opponent is an item, chest, or potion, the champion interacts with it.
     * If the opponent is a potion, the champion's health is restored to its maximum value.
     * If the opponent is a chest, there is a chance of triggering a trap. If not trapped, the champion receives either a sword or a shield.
     * If the opponent is an item, the champion receives a random attribute boost or a shield.
     * The map is updated accordingly, and the opponent is removed from the map.
     *
     * @param champ The champion performing the action.
     * @param opponent The opponent occupying the champion's desired location.
     */
    private void interaction(Champion champ, Champion opponent) {
        // If the opponent is another orc, human, or elf, a fight occurs
        switch (opponent.getType()) {
            case "ork", "human", "elf" -> {
                if (champ.getType().equals(opponent.getType())) {
                    opponent.increaseLevel();
                } else {
                    // Simple fight implementation and map stats update
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
                            if(!opponent.getShield()){// without a shield
                                opponent.takeDMG(champ.getStrength(), champ.getLevel(), champ.getRange(), champ.getLuck());
                            }
                            else{
                                opponent.setShield(false);
                            }
                            // no dmg if with shield
                        } else {
                            if(champ.getSword())//sword makes hit stronger
                            {
                                champ.takeDMG(opponent.getStrength()+2, opponent.getLevel(), opponent.getRange()+2, opponent.getLuck());
                                champ.setSword(false);
                            }
                            else {//normal hit
                                champ.takeDMG(opponent.getStrength(), opponent.getLevel(), opponent.getRange(), opponent.getLuck());
                            }

                        }
                        iterator++;
                    }

                    if (opponent.getHp() <= 0) {
                        mapDelete(champ.getY_index(), champ.getX_index());
                        champ.newIndex(opponent.getY_index(), opponent.getX_index());

                        mapDelete(opponent.getY_index(), opponent.getX_index());
                        map.get(opponent.getY_index()).set(opponent.getX_index(), champ);//kill by the winning

                        decreaseStatistics(opponent.getType());
                        announcements.add(" "+champ.getType()+" killed "+opponent.getType());
                    } else if (champ.getHp() <= 0) {
                        mapDelete(champ.getY_index(), champ.getX_index());

                        decreaseStatistics(champ.getType());
                        announcements.add(" "+opponent.getType()+" killed "+champ.getType());
                    }
                }
            }
            // If the opponent is an item, chest, or potion
            case "item", "chest", "potion" -> {
                // Potion interaction
                if(Objects.equals(opponent.getType(), "potion"))
                {
                    champ.setHp(champ.getMaxHp());
                    announcements.add(" "+champ.getType()+" drank potion");
                }
                // Chest interaction
                else if(Objects.equals(opponent.getType(), "chest"))
                {
                    if(Chest.isMimicGenerate()) {
                        champ.setHp(champ.getMaxHp() / 10);//wpadł w pułapkę
                        announcements.add(" " + champ.getType() + " fell into the trap");
                    }
                    if(Chest.whatsInside()){
                        champ.setSword(true);//picks up sword
                        announcements.add(" "+champ.getType()+" was equipped with sword");
                    }else {
                        champ.setShield(true);//picks up shield
                        announcements.add(" "+champ.getType()+" was equipped with shield");
                    }
                }
                // Item interaction
                else if(Objects.equals(opponent.getType(), "item"))
                {
                    Random generator = new Random();
                    int randommove = generator.nextInt(4);
                    switch (randommove)
                    {
                        case 0 -> {
                            champ.setHp(champ.getHp()+3);//gets hp
                            champ.setMaxHp(champ.getMaxHp()+3);//max hp
                            announcements.add(" "+champ.getType()+" got a life boost");
                        }
                        case 1 -> {
                            champ.setLuck(champ.getLuck()+10);//gets luck
                            announcements.add(" "+champ.getType()+" got a luck boost");
                        }
                        case 2 -> {
                            champ.setStrength(champ.getStrength()+3);//gets strenght
                            announcements.add(" "+champ.getType()+" got a strenght boost");
                        }
                        case 3 -> {
                            champ.setShield(true);//gets shield
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

    /**
     * Decreases the statistics based on the given type.
     *
     * @param type The type of the object to decrease statistics for.
     */
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
                // Do nothing for unknown types
            }
        }
    }

    /**
     * Removes an object from the map matrix at the specified coordinates.
     *
     * @param yIndex The y-coordinate of the object to be removed.
     * @param xIndex The x-coordinate of the object to be removed.
     */
    private void mapDelete(int yIndex, int xIndex) {
        map.get(yIndex).set(xIndex, null);
    }

    /**
     * Clears the console screen.
     * This method attempts to clear the console screen by executing platform-specific commands.
     * On Windows, it uses the "cls" command to clear the screen.
     * On other platforms, it executes the "clear" command and also sends control characters to reset the cursor position.
     * If any exception occurs during the process, it will be printed to the standard error output.
     */
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

    /**
     * Checks if the game has reached its end condition.
     * The end conditions are:
     * - If there are no more elves and humans remaining, the orcs have conquered the battlefield.
     * - If there are no more elves and orcs remaining, the humans have conquered the battlefield.
     * - If there are no more orcs and humans remaining, the elves have conquered the battlefield.
     *
     * @return {@code true} if the game has not reached its end condition yet, {@code false} otherwise.
     */
    public boolean ifend() throws FileNotFoundException {
        String message;
        String wall = "\u001B[90m║\u001B[37m";
        if (numberOfElfs == 0 && numberOfHumans == 0) {
            message = "\u001B[90m╔\n\u001B[90m║\u001B[37m\u001B[32mOrki podbiły pole bitwy!\n\u001B[90m╚\u001B[0m";
            writeResult(message);
            System.out.println("\u001B[90m╔");
            System.out.println(wall+" \u001B[32mOrki podbiły pole bitwy!");
            System.out.println("\u001B[90m╚\u001B[0m");
            return false;
        }
        if (numberOfElfs == 0 && numberOfOrks == 0) {
            message = "\u001B[90m╔\n\u001B[90m║\u001B[37m\u001B[32mLudzie podbili pole bitwy!\n\u001B[90m╚\u001B[0m";
            writeResult(message);
            System.out.println("\u001B[90m╔");
            System.out.println(wall+" \u001B[34mLudzie podbili pole bitwy!");
            System.out.println("\u001B[90m╚\u001B[0m");
            return false;
        }
        if (numberOfOrks == 0 && numberOfHumans == 0) {
            message = "\u001B[90m╔\n\u001B[90m║\u001B[37m\u001B[32mElfy podbiły pole bitwy!\n\u001B[90m╚\u001B[0m";
            writeResult(message);
            System.out.println("\u001B[90m╔");
            System.out.println(wall+" \u001B[33mElfy podbiły pole bitwy!");
            System.out.println("\u001B[90m╚\u001B[0m");
            return false;
        }
        return true;

    }

    /**
     * Checks if there are any announcements.
     *
     * @return {@code true} if there are no announcements, {@code false} otherwise.
     */
    public boolean ifstop(){
        // Check if the list of announcements is empty
        if(announcements.isEmpty()){
            // If the list is empty, there are no announcements, so return true
            return true;
        }
        else{
            // If the list is not empty, there are announcements, so return false
            return false;
        }
    }

    public void writeResult(String value) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("RESULTS.txt");
        zapis.println("Tyle dni trwała symulacja: "+dayCyclesPassed+"\n"+value);
        zapis.close();
    }

}