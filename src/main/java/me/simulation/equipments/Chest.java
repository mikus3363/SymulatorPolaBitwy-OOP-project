package me.simulation.equipments;
import java.util.*;

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

    public static boolean isMimicGenerate(){
        Random ran = new Random();
        if(ran.nextInt(50)<=5){
            return true;
        }
        else {
            return false;
        }
    }

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
