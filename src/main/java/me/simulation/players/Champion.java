package me.simulation.players;
import me.simulation.game.Interaction;

public abstract class Champion implements Interaction {
    public String race;
    public String type;
    public int level;
    public int hp;
    public int strength;
    public int range;
    public int luck;
    public boolean has_shield;
    public boolean has_sword;
    public int x_index;
    public int y_index;


    public int getX_index(){
        return x_index;
    }
    public int getY_index(){
        return y_index;
    }



}
