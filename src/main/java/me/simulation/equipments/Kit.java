package me.simulation.equipments;

import me.simulation.game.Interaction;

public abstract class Kit implements Interaction {
    public String type;
    public int x_index;
    public int y_index;
    public int getX_index(){
        return x_index;
    }
    public int getY_index(){
        return y_index;
    }

}
