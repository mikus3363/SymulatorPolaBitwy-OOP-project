package me.simulation.game;

import me.simulation.players.Champion;

import java.util.ArrayList;

public interface Interaction {
    //public void interaction();
    default void newIndex(int newY, int newX){
    }
    default int getXIndex(){
        return 1;
    }
    default int getYIndex(){
        return 1;
    }
    default int getHp(){
        return 1;
    }
    default int getMaxHp(){
        return 1;
    }
    default int getLvl(){
        return 1;
    }
}
