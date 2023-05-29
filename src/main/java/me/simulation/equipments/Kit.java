package me.simulation.equipments;

import me.simulation.game.Interaction;
import me.simulation.players.Champion;

public abstract class Kit extends Champion implements Interaction {
    public int getX_index(){
        return x_index;
    }
    public int getY_index(){
        return y_index;
    }

}
