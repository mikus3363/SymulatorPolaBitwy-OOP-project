package me.simulation.players;
import me.simulation.game.Interaction;

public abstract class Champion implements Interaction {
    public String type;
    public int level;
    public int maxhp;
    public int hp;
    public int strength;
    public int range;
    public int luck;
    public boolean move;
    public boolean has_shield;
    public boolean has_sword;
    public int x_index;
    public int y_index;


    @Override
    public void newIndex(int newY, int newX){
       this.x_index = newX;
       this.y_index = newY;
    }
    @Override
    public int getXIndex(){
        return x_index;
    }
    public int getYIndex(){
        return y_index;
    }
    public int getHp(){
        return hp;
    }
    public int getMaxHp(){
        return maxhp;
    }
    public int getLevel(){
        return level;
    }



}
