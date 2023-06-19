package me.simulation.players;


public class Human extends Champion {
    /**
     * Constructs a new Human object with the specified attributes.
     *
     * @param type        the type of the human
     * @param level       the level of the human
     * @param maxhp       the maximum hit points of the human
     * @param hp          the current hit points of the human
     * @param strength    the strength of the human
     * @param range       the attack range of the human
     * @param luck        the luck factor of the human
     * @param move        indicates whether the human can move
     * @param has_shield  indicates whether the human has a shield
     * @param has_sword   indicates whether the human has a sword
     * @param x_index     the x-coordinate of the human's position
     * @param y_index     the y-coordinate of the human's position
     */
    public Human(String type, int level,int maxhp, int hp, int strength, int range, int luck,boolean move, boolean has_shield, boolean has_sword, int x_index, int y_index){
        super(type, level, maxhp, hp, strength, range, luck, move, has_shield, has_sword, x_index, y_index);
    }
}
