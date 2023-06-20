package me.simulation.players;

/**
 * Represents an Elf player in the simulation.
 * Extends the Champion class.
 */
public class Elf extends Champion {

    /**
     * Constructs an Elf object with the specified attributes.
     *
     * @param type         the type of the Elf
     * @param level        the level of the Elf
     * @param maxhp        the maximum hit points of the Elf
     * @param hp           the current hit points of the Elf
     * @param strength     the strength of the Elf
     * @param range        the attack range of the Elf
     * @param luck         the luck factor of the Elf
     * @param move         indicates if the Elf can move
     * @param has_shield   indicates if the Elf has a shield
     * @param has_sword    indicates if the Elf has a sword
     * @param x_index      the x index position of the Elf
     * @param y_index      the y index position of the Elf
     * @param regeneration indicates if the Elf has regeneration ability
     */
    public Elf(String type, int level,int maxhp, int hp, int strength, int range, int luck,boolean move, boolean has_shield, boolean has_sword, int x_index, int y_index, boolean regeneration){
        super(type, level, maxhp, hp, strength, range, luck, move, has_shield, has_sword, x_index, y_index,regeneration);
    }

    /**
     * Simulates the act of killing an opponent.
     *
     * @param Opponent the name of the opponent being killed
     * @return a string indicating that the Elf killed the opponent
     */
    public static String kill(String Opponent){
        return " Elf killed " + Opponent;
    }

    /**
     * Simulates the act of picking up a kit.
     *
     * @param Kit the name of the kit being picked up
     * @return a string indicating that the Elf picked up the kit
     */
    public static String pickUp(String Kit){
        return " Elf picked up" + Kit;
    }

    /**
     * Simulates the act of falling into a trap.
     *
     * @return a string indicating that the Elf fell into a trap
     */
    static String trap(){
        return " Elf fell into the trap";
    }

    /**
     * Simulates the act of receiving a boost of a certain type.
     *
     * @param type the type of boost received by the Elf
     * @return a string indicating that the Elf received a boost of the specified type
     */
    static String boost(String type){
        return " Elf got a "+type+" boost";
    }
}
