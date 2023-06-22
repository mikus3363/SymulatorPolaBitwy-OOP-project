package me.simulation.players;


import me.simulation.game.Interaction;

/**
 * Represents a Ork player in the simulation.
 * Extends the Champion class.
 */
public class Ork extends Champion implements Interaction {

    /**
     * Constructor for creating an Ork object.
     *
     * @param type the type of the champion
     * @param level the level of the champion
     * @param maxhp the maximum health points of the champion
     * @param hp the current health points of the champion
     * @param strength the strength of the champion
     * @param range the attack range of the champion
     * @param luck the luck attribute of the champion
     * @param move the movement status of the champion
     * @param has_shield the shield status of the champion
     * @param has_sword the sword status of the champion
     * @param x_index the x-coordinate index of the champion's position
     * @param y_index the y-coordinate index of the champion's position
     * @param regeneration the regeneration status of the champion
     */
    public Ork(String type, int level,int maxhp, int hp, int strength, int range, int luck,boolean move, boolean has_shield, boolean has_sword, int x_index, int y_index,boolean regeneration){
        super(type, level, maxhp, hp, strength, range, luck, move, has_shield, has_sword, x_index, y_index,regeneration);
    }

    /**
     * Kills the opponent and returns a string describing the action.
     *
     * @param Opponent the name of the opponent being killed
     * @return a string describing the kill action
     */
    public static String kill(String Opponent){
        return " Ork killed " + Opponent;
    }

    /**
     * Picks up a kit and returns a string describing the action.
     *
     * @param Kit the name of the kit being picked up
     * @return a string describing the pickup action
     */
    public static String pickUp(String Kit){
        return " Ork picked up" + Kit;
    }

    /**
     * Simulates the Ork falling into a trap and returns a string describing the action.
     *
     * @return a string describing the trap action
     */
    static String trap(){
        return " Ork fell into the trap";
    }

    /**
     * Boosts the Ork with a specific type of boost and returns a string describing the action.
     *
     * @param type the type of boost
     * @return a string describing the boost action
     */
    static String boost(String type){
        return " Ork got a "+type+" boost";
    }
}
