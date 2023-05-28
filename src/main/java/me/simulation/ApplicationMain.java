package me.simulation;

import java.util.*;
import me.simulation.equipments.*;
import me.simulation.game.Map;
import me.simulation.players.*;

//test git
public class ApplicationMain {
    public static void main(String[] args) {
        Ork ork1 = new Ork("ork", 5,20,10,1,0,false,false,2,3);
        System.out.printf("Index Orka: "+ork1.getX_index());
        ork1.getX_index();
        ork1.getY_index();
        Map map1 = new Map(12,12);

    }
}


