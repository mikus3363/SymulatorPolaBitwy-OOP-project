package me.simulation.players;

/**
 * Represents a Human player in the simulation.
 * Extends the Champion class.
 */
public class Human extends Champion {

    /**
     * Constructs a Human object with the specified attributes.
     *
     * @param type         the type of the Human
     * @param level        the level of the Human
     * @param maxhp        the maximum hit points of the Human
     * @param hp           the current hit points of the Human
     * @param strength     the strength of the Human
     * @param range        the attack range of the Human
     * @param luck         the luck factor of the Human
     * @param move         indicates if the Human can move
     * @param has_shield   indicates if the Human has a shield
     * @param has_sword    indicates if the Human has a sword
     * @param x_index      the x index position of the Human
     * @param y_index      the y index position of the Human
     * @param regeneration indicates if the Human has regeneration ability
     */
    public Human(String type, int level,int maxhp, int hp, int strength, int range, int luck,boolean move, boolean has_shield, boolean has_sword, int x_index, int y_index,boolean regeneration){
        super(type, level, maxhp, hp, strength, range, luck, move, has_shield, has_sword, x_index, y_index,regeneration);
    }

    /**
     * Simulates the act of killing an opponent.
     *
     * @param Opponent the name of the opponent being killed
     * @return a string indicating that the Human killed the opponent
     */
    public static String kill(String Opponent){
        return " Human killed " + Opponent;
    }

    /**
     * Simulates the act of picking up a kit.
     *
     * @param Kit the name of the kit being picked up
     * @return a string indicating that the Human picked up the kit
     */
    public static String pickUp(String Kit){
        return " Human picked up" + Kit;
    }

    /**
     * Simulates the act of falling into a trap.
     *
     * @return a string indicating that the Human fell into a trap
     */
    static String trap(){
        return " Human fell into the trap";
    }

    /**
     * Simulates the act of receiving a boost of a certain type.
     *
     * @param type the type of boost received by the Human
     * @return a string indicating that the Human received a boost of the specified type
     */
    static String boost(String type){
        return " Human got a "+type+" boost";
    }
}
