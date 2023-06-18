package me.simulation.players;
import me.simulation.game.Interaction;

public abstract class Champion implements Interaction {
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

    /**
     * Constructs a new Champion object with the specified type, x-index, and y-index.
     *
     * @param type      the type of the champion
     * @param x_index   the x-coordinate of the champion's position
     * @param y_index   the y-coordinate of the champion's position
     */
    public Champion(String type, int x_index, int y_index){
        this.type = type;
        this.x_index = x_index;
        this.y_index = y_index;
    }

    /**
     * Constructs a new Champion object with the specified attributes.
     *
     * @param type         the type of the champion
     * @param level        the level of the champion
     * @param maxhp        the maximum hit points of the champion
     * @param hp           the current hit points of the champion
     * @param strength     the strength of the champion
     * @param range        the attack range of the champion
     * @param luck         the luck factor of the champion
     * @param move         indicates whether the champion can move
     * @param has_shield   indicates whether the champion has a shield
     * @param has_sword    indicates whether the champion has a sword
     * @param x_index      the x-coordinate of the champion's position
     * @param y_index      the y-coordinate of the champion's position
     */
    public Champion(String type, int level,int maxhp, int hp, int strength, int range, int luck,boolean move, boolean has_shield, boolean has_sword, int x_index, int y_index){
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
    }

    /**
     * Updates the champion's position to the specified new y-coordinate and x-coordinate.
     *
     * @param newY  the new y-coordinate of the champion's position
     * @param newX  the new x-coordinate of the champion's position
     */
    @Override
    public void newIndex(int newY, int newX) {
        this.x_index = newX;
        this.y_index = newY;
    }

    /**
     * Retrieves the move status of the champion.
     *
     * @return true if the champion can move, false otherwise
     */
    @Override
    public boolean getMove(){
        return move;
    }

    /**
     * Sets the move status of the champion.
     *
     * @param value  the new move status of the champion
     */
    @Override
    public void setMove(boolean value){
        this.move = value;
    }

    /**
     * Retrieves the type of the champion.
     *
     * @return the type of the champion
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * Retrieves the x-coordinate of the champion's position.
     *
     * @return the x-coordinate of the champion's position
     */
    @Override
    public int getX_index() {
        return x_index;
    }

    /**
     * Retrieves the y-coordinate of the champion's position.
     *
     * @return the y-coordinate of the champion's position
     */
    @Override
    public int getY_index() {
        return y_index;
    }

    /**
     * Retrieves the strength of the champion.
     *
     * @return the strength of the champion
     */
    @Override
    public int getStrength() {
        return strength;
    }

    /**
     * Retrieves the attack range of the champion.
     *
     * @return the attack range of the champion
     */
    @Override
    public int getRange() {
        return range;
    }

    /**
     * Retrieves the luck factor of the champion.
     *
     * @return the luck factor of the champion
     */
    @Override
    public int getLuck() {
        return luck;
    }

    /**
     * Retrieves the current hit points of the champion.
     *
     * @return the current hit points of the champion
     */
    @Override
    public int getHp() {
        return hp;
    }

    /**
     * Updates the champion's hit points based on the damage taken.
     *
     * @param strength  the strength of the attacker
     * @param level     the level of the attacker
     * @param range     the attack range of the attacker
     * @param luck      the luck factor of the attacker
     */
    public void takeDMG(int strength, int level, int range, int luck){
        int amount = (strength+level)/(2);
        this.hp -= amount;
    }

    /**
     * Retrieves the maximum hit points of the champion.
     *
     * @return the maximum hit points of the champion
     */
    @Override
    public int getMaxHp() {
        return maxhp;
    }

    /**
     * Retrieves the level of the champion.
     *
     * @return the level of the champion
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     * Increases the level of the champion.
     */
    public void increaseLevel(){
        this.level++;
    }

    /**
     * Retrieves the status of whether the champion has a sword.
     *
     * @return true if the champion has a sword, false otherwise
     */
    @Override
    public boolean getSword() {
        return has_sword;
    }

    /**
     * Retrieves the status of whether the champion has a shield.
     *
     * @return true if the champion has a shield, false otherwise
     */
    @Override
    public boolean getSchield() {
        return has_shield;
    }

}