package me.simulation.equipments;

import me.simulation.game.Interaction;
import me.simulation.players.Champion;


public abstract class Kit extends Champion implements Interaction {

    public Kit(String type, int x_index, int y_index) {
        super(type, x_index, y_index);
    }
}
