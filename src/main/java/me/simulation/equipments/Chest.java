package me.simulation.equipments;
import java.util.*;

/**
 * Represents a Chest class
 */
public class Chest extends Kit{
    /**
     * Constructs a new Chest object with the specified attributes.
     *
     * @param type     the type of the chest
     * @param x_index  the x-coordinate of the chest's position
     * @param y_index  the y-coordinate of the chest's position
     */
    public Chest(String type,int x_index,int y_index){
        super(type,x_index,y_index);
    }

    /**
     * Determines whether a mimic should be generated.
     * @return true if a mimic should be generated, false otherwise
     */
    public static boolean isMimicGenerate(){
        Random ran = new Random();
        if(ran.nextInt(50)<=5){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *Determines what is inside a container.
     *@return true if the container contains a sword, false if it contains a shield
     */
    public static boolean whatsInside(){
        Random ran = new Random();
        if(ran.nextInt(50)<=24){
            // TURE for SWORD
            return true;
        }
        else {
            // FALSE for SHIELD
            return false;
        }
    }
}
