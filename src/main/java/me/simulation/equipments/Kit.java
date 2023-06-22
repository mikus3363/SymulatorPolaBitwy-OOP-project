package me.simulation.equipments;

import me.simulation.players.Champion;

/**
 * Represents an abstract Kit in the simulation.
 */
public abstract class Kit extends Champion {
    /**
     * Constructs a new Kit object with the specified type, x-index, and y-index.
     *
     * @param type      the type of the kit
     * @param x_index   the x-coordinate of the kit's position
     * @param y_index   the y-coordinate of the kit's position
     */
    public Kit(String type, int x_index, int y_index) {
        super(type, x_index, y_index);
    }
}
