package me.simulation.game;

/**
 *This interface represents the default required behaviors for a game entity.
 */
public interface DefaultRequired {

    /**
     * Sets the movement state of the entity.
     *
     * @param value true if the entity can move, false otherwise
     */
    void setMove(boolean value);

    /**
     * Sets the new index position of the entity.
     *
     * @param newY the new y-coordinate index
     * @param newX the new x-coordinate index
     */
    default void newIndex(int newY, int newX){}

    /**
     * Returns the x-coordinate index of the entity.
     *
     * @return the x-coordinate index
     */
    default int getX_index(){
        return 1;
    }

    /**
     * Returns the y-coordinate index of the entity.
     *
     * @return the y-coordinate index
     */
    default int getY_index(){
        return 1;
    }

    /**
     * Returns the current hit points (HP) of the entity.
     *
     * @return the current hit points
     */
    default int getHp(){
        return 1;
    }

    /**
     * Returns the maximum hit points (HP) of the entity.
     *
     * @return the maximum hit points
     */
    default int getMaxHp(){
        return 1;
    }

    /**
     * Returns the level of the entity.
     *
     * @return the level
     */
    default int getLvl(){
        return 1;
    }

    /**
     * Returns the strength of the entity.
     *
     * @return the strength value
     */
    default int getStrength() {
        return 1;
    }

    /**
     * Returns the attack range of the entity.
     *
     * @return the attack range
     */
    default int getRange() {
        return 1;
    }

    /**
     * Returns the type of the entity.
     *
     * @return the type
     */
    default String getType(){
        return "default";
    }

    /**
     * Returns the luck value of the entity.
     *
     * @return the luck value
     */
    default int getLuck() {
        return 1;
    }

    /**
     * Returns the level of the entity.
     *
     * @return the level
     */
    default int getLevel() {
        return 1;
    }

    /**
     * Returns the movement state of the entity.
     *
     * @return true if the entity can move, false otherwise
     */
    default boolean getMove() {
        return false;
    }

    /**
     * Returns the availability of a sword for the entity.
     *
     * @return true if the entity has a sword, false otherwise
     */
    default boolean getSword() {
        return false;
    }

    /**
     * Returns the availability of a shield for the entity.
     *
     * @return true if the entity has a shield, false otherwise
     */
    default boolean getShield() {
        return false;
    }

    /**
     * Returns the availability of regeneration for the entity.
     *
     * @return true if the entity has regeneration, false otherwise
     */
    default boolean getRegeneration(){
        return false;
    }
}
