package me.simulation.equipments;

/**
 * Represents a Potion class
 */
public class Potion extends Kit{

    boolean greatPotion;

    /**
     * Constructs a new Potion object with the specified attributes.
     *
     * @param type     the type of the potion
     * @param x_index  the x-coordinate of the potion's position
     * @param y_index  the y-coordinate of the potion's position
     */
    public Potion(String type,int x_index,int y_index){
        super(type,x_index,y_index);
    }
}
