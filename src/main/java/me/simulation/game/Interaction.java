package me.simulation.game;

public interface Interaction {

    /**
     * Sets the movement status of the object.
     *
     * @param value true if the object can move, false otherwise
     */
    void setMove(boolean value);

    /**
     * Sets the new position of the object with the specified y-coordinate and x-coordinate.
     *
     * @param newY the new y-coordinate of the object's position
     * @param newX the new x-coordinate of the object's position
     */
    default void newIndex(int newY, int newX){}

    /**
     * Retrieves the x-coordinate of the object's position.
     *
     * @return the x-coordinate of the object's position
     */
    default int getX_index(){
        return 1;
    }

    /**
     * Retrieves the y-coordinate of the object's position.
     *
     * @return the y-coordinate of the object's position
     */
    default int getY_index(){
        return 1;
    }

    /**
     * Retrieves the current hit points of the object.
     *
     * @return the current hit points of the object
     */
    default int getHp(){
        return 1;
    }

    /**
     * Retrieves the maximum hit points of the object.
     *
     * @return the maximum hit points of the object
     */
    default int getMaxHp(){
        return 1;
    }

    /**
     * Retrieves the level of the object.
     *
     * @return the level of the object
     */
    default int getLvl(){
        return 1;
    }

    /**
     * Retrieves the strength of the object.
     *
     * @return the strength of the object
     */
    default int getStrength() {
        return 1;
    }

    /**
     * Retrieves the attack range of the object.
     *
     * @return the attack range of the object
     */
    default int getRange() {
        return 1;
    }

    /**
     * Retrieves the type of the object.
     *
     * @return the type of the object
     */
    default String getType(){
        return "default";
    }

    /**
     * Retrieves the luck factor of the object.
     *
     * @return the luck factor of the object
     */
    default int getLuck() {
        return 1;
    }

    /**
     * Retrieves the level of the object.
     *
     * @return the level of the object
     */
    default int getLevel() {
        return 1;
    }

    /**
     * Retrieves the movement status of the object.
     *
     * @return true if the object can move, false otherwise
     */
    default boolean getMove() {
        return false;
    }

    /**
     * Retrieves the status of whether the object has a sword.
     *
     * @return true if the object has a sword, false otherwise
     */
    default boolean getSword() {
        return false;
    }

    /**
     * Retrieves the status of whether the object has a shield.
     *
     * @return true if the object has a shield, false otherwise
     */
    default boolean getSchield() {
        return false;
    }
}
