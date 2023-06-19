package me.simulation.equipments;

public class Potion extends Kit{
    /**
     * Constructs a new Potion object with the specified attributes.
     *
     * @param type     the type of the potion
     * @param x_index  the x-coordinate of the potion's position
     * @param y_index  the y-coordinate of the potion's position
     */
    boolean greatPotion;
    public Potion(String type,int x_index,int y_index){
        super(type,x_index,y_index);
    }
}
