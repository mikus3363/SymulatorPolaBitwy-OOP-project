package me.simulation.game;

import me.simulation.players.Champion;

import java.util.ArrayList;

public interface Interaction {
    void setMove(boolean value);
    default void newIndex(int newY, int newX){}
    default int getX_index(){
        return 1;
    }
    default int getY_index(){
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
    default int getStrength() {
        return 1;
    }
    default int getRange() {
        return 1;
    }
    default String getType(){
        return "default";
    }
    default int getLuck() {
        return 1;
    }
    default int getLevel() {
        return 1;
    }
    default boolean getMove() {
        return false;
    }
    default boolean getSword() {
        return false;
    }
    default boolean getSchield() {
        return false;
    }
}
