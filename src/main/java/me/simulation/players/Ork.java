package me.simulation.players;


public class Ork extends Champion {
    /**
     * Constructs a new Ork object with the specified attributes.
     *
     * @param type        the type of the ork
     * @param level       the level of the ork
     * @param maxhp       the maximum hit points of the ork
     * @param hp          the current hit points of the ork
     * @param strength    the strength of the ork
     * @param range       the attack range of the ork
     * @param luck        the luck factor of the ork
     * @param move        indicates whether the ork can move
     * @param has_shield  indicates whether the ork has a shield
     * @param has_sword   indicates whether the ork has a sword
     * @param x_index     the x-coordinate of the ork's position
     * @param y_index     the y-coordinate of the ork's position
     */
    public Ork(String type, int level,int maxhp, int hp, int strength, int range, int luck,boolean move, boolean has_shield, boolean has_sword, int x_index, int y_index){
        super(type, level, maxhp, hp, strength, range, luck, move, has_shield, has_sword, x_index, y_index);
    }

}
