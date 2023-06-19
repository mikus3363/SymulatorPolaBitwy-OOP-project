package me.simulation.players;


public class Elf extends Champion {
    /**
     * Constructs a new Elf object with the specified attributes.
     *
     * @param type        the type of the elf
     * @param level       the level of the elf
     * @param maxhp       the maximum hit points of the elf
     * @param hp          the current hit points of the elf
     * @param strength    the strength of the elf
     * @param range       the attack range of the elf
     * @param luck        the luck factor of the elf
     * @param move        indicates whether the elf can move
     * @param has_shield  indicates whether the elf has a shield
     * @param has_sword   indicates whether the elf has a sword
     * @param x_index     the x-coordinate of the elf's position
     * @param y_index     the y-coordinate of the elf's position
     */
    public Elf(String type, int level,int maxhp, int hp, int strength, int range, int luck,boolean move, boolean has_shield, boolean has_sword, int x_index, int y_index){
        super(type, level, maxhp, hp, strength, range, luck, move, has_shield, has_sword, x_index, y_index);
    }

}
