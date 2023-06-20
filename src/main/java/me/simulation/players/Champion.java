package me.simulation.players;
import me.simulation.game.DefaultRequired;
import java.util.Random;

/**
 * Represents an abstract Champion in the simulation.
 * Implements the DefaultRequired interface.
 */
public abstract class Champion implements DefaultRequired {
    private final String type;
    private int level;
    private int maxhp;
    private int hp;
    private int strength;
    private int range;
    private int luck;
    private boolean move;
    private boolean has_shield;
    private boolean has_sword;
    private int x_index;
    private int y_index;
    private boolean regeneration;

    /**
     * Constructs a Champion object with the specified type, x index, and y index.
     *
     * @param type     the type of the Champion
     * @param x_index  the x index position of the Champion
     * @param y_index  the y index position of the Champion
     */
    public Champion(String type, int x_index, int y_index){
        this.type = type;
        this.x_index = x_index;
        this.y_index = y_index;
    }

    /**
     * Constructs a Champion object with the specified attributes.
     *
     * @param type         the type of the Champion
     * @param level        the level of the Champion
     * @param maxhp        the maximum hit points of the Champion
     * @param hp           the current hit points of the Champion
     * @param strength     the strength of the Champion
     * @param range        the attack range of the Champion
     * @param luck         the luck factor of the Champion
     * @param move         indicates if the Champion can move
     * @param has_shield   indicates if the Champion has a shield
     * @param has_sword    indicates if the Champion has a sword
     * @param x_index      the x index position of the Champion
     * @param y_index      the y index position of the Champion
     * @param regeneration indicates if the Champion has regeneration ability
     */
    public Champion(String type, int level,int maxhp, int hp, int strength, int range, int luck,boolean move, boolean has_shield, boolean has_sword, int x_index, int y_index,boolean regeneration){
        this.type = type;
        this.level = level;
        this.maxhp = maxhp;
        this.hp = hp;
        this.strength = strength;
        this.range = range;
        this.luck = luck;
        this.move = move;
        this.has_shield = has_shield;
        this.has_sword = has_sword;
        this.x_index = x_index;
        this.y_index = y_index;
        this.regeneration = regeneration;
    }

    /**
     * Updates the champion's position with new indices.
     *
     * @param newY the new y-coordinate index
     * @param newX the new x-coordinate index
     */
    @Override
    public void newIndex(int newY, int newX) {
        this.x_index = newX;
        this.y_index = newY;
    }

    /**
     * Retrieves the move status of the Champion.
     *
     * @return true if the Champion can move, false otherwise
     */
    @Override
    public boolean getMove(){
        return move;
    }

    /**
     * Sets the move status of the Champion.
     *
     * @param value the move status of the Champion
     */
    @Override
    public void setMove(boolean value){
        this.move = value;
    }

    /**
     * Retrieves the type of the Champion.
     *
     * @return the type of the Champion
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * Retrieves the x index position of the Champion.
     *
     * @return the x index position of the Champion
     */
    @Override
    public int getX_index() {
        return x_index;
    }

    /**
     * Retrieves the y index position of the Champion.
     *
     * @return the y index position of the Champion
     */
    @Override
    public int getY_index() {
        return y_index;
    }

    /**
     * Retrieves the strength of the Champion.
     *
     * @return the strength of the Champion
     */
    @Override
    public int getStrength() {
        return strength;
    }

    /**
     * Sets the strength of the Champion.
     *
     * @param power the strength of the Champion
     */
    public void setStrength(int power){ this.strength = power; }

    /**
     * Retrieves the attack range of the Champion.
     *
     * @return the attack range of the Champion
     */
    @Override
    public int getRange() {
        return range;
    }

    /**
     * Retrieves the luck factor of the Champion.
     *
     * @return the luck factor of the Champion
     */
    @Override
    public int getLuck() {
        return luck;
    }

    /**
     * Sets the luck factor of the Champion.
     *
     * @param luck the luck factor of the Champion
     */
    public void setLuck(int luck){ this.luck = luck; }

    /**
     * Retrieves the current hit points of the Champion.
     *
     * @return the current hit points of the Champion
     */
    @Override
    public int getHp() {
        return hp;
    }

    /**
     * Sets the current hit points of the Champion.
     *
     * @param change the new current hit points of the Champion
     */
    public void setHp(int change){ this.hp = change; }

    /**
     * Simulates the Champion taking damage based on various factors.
     *
     * @param strength the strength factor for calculating damage
     * @param level    the level of the Champion
     * @param range    the attack range of the Champion
     * @param luck     the luck factor for calculating damage
     */
    public void takeDMG(int strength, int level, int range, int luck){
        int amount = (strength+level+range)/(3);
        Random ran = new Random();
        if(ran.nextInt(20)<=luck){
            this.hp -= amount*2;
        } else {
            this.hp -= amount;
        }
    }

    /**
     * Retrieves the maximum hit points of the Champion.
     *
     * @return the maximum hit points of the Champion
     */
    @Override
    public int getMaxHp() {
        return maxhp;
    }

    /**
     * Sets the maximum hit points of the Champion.
     *
     * @param maxhp the maximum hit points of the Champion
     */
    public void setMaxHp(int maxhp) {this.maxhp = maxhp;}

    /**
     * Retrieves the level of the Champion.
     *
     * @return the level of the Champion
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     * Increases the level of the Champion.
     */
    public void increaseLevel(){
        this.level++;
    }

    /**
     * Retrieves the availability of a sword for the Champion.
     *
     * @return true if the Champion has a sword, false otherwise
     */
    @Override
    public boolean getSword() {
        return has_sword;
    }

    /**
     * Sets the status of the champion's sword.
     *
     * @param has_sword the status of the sword to set
     */
    public void setSword(boolean has_sword){this.has_sword = has_sword;}

    /**
     * Returns the status of the champion's shield.
     *
     * @return true if the champion has a shield, false otherwise
     */
    @Override
    public boolean getShield() {
        return has_shield;
    }

    /**
     * Sets the status of the champion's shield.
     *
     * @param has_shield the status of the shield to set
     */
    public void setShield(boolean has_shield){this.has_shield = has_shield;}

    /**
     * Returns the status of the champion's regeneration.
     *
     * @return true if the champion has regeneration, false otherwise
     */
    @Override
    public boolean getRegeneration(){
        return regeneration;
    }

    /**
     * Sets the status of the champion's regeneration.
     *
     * @param regen the status of the regeneration to set
     */
    public void setRegeneration(boolean regen){this.regeneration = regen;}
}