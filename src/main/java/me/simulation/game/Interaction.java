package me.simulation.game;

public interface Interaction {

    /**
     * Kills the opponent champion.
     *
     * @param opponent the opponent champion's name
     * @return a message indicating the champion killed the opponent
     */
    static String kill(String opponent){
        return "Champion killed Opponent";
    }

    /**
     * Picks up a kit.
     *
     * @return a message indicating the champion picked up a kit
     */
    static String pickUp(){
        return "Champion picked up Kit";
    }

    /**
     * Traps the champion.
     *
     * @return a message indicating the champion fell into a trap
     */
    static String trap(){
        return "Champion fell into the trap";
    }

    /**
     * Provides a boost to the champion.
     *
     * @return a message indicating the champion received a boost
     */
    static String boost(){
        return "Champion got a boost";
    }
}
