package me.simulation.equipments;

/**
 * Represents a Kit class
 */
public class Item extends Kit{
    /**
     * Constructs a new Item object with the specified attributes.
     *
     * @param type     the type of the item
     * @param x_index  the x-coordinate of the item's position
     * @param y_index  the y-coordinate of the item's position
     */
    public Item(String type,int x_index,int y_index){
        super(type,x_index,y_index);
    }
}
