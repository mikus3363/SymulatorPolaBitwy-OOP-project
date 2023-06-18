package me.simulation.players;
import me.simulation.game.Interaction;

public abstract class Champion implements Interaction {
    private final String type;
    private int level;
    private int maxhp;
    private int hp;
    private int strength;
    private int range;
    private int luck;
    private boolean move;
    private boolean has_shield;
    private boolean has_sword;
    private int x_index;
    private int y_index;
    //public int x_index;
    //public int y_index;
    private boolean regeneration;

    public Champion(String type, int x_index, int y_index){
        this.type = type;
        this.x_index = x_index;
        this.y_index = y_index;
    }
    public Champion(String type, int level,int maxhp, int hp, int strength, int range, int luck,boolean move, boolean has_shield, boolean has_sword, int x_index, int y_index,boolean regeneration){
        this.type = type;
        this.level = level;
        this.maxhp = maxhp;
        this.hp = hp;
        this.strength = strength;
        this.range = range;
        this.luck = luck;
        this.move = move;
        this.has_shield = has_shield;
        this.has_sword = has_sword;
        this.x_index = x_index;
        this.y_index = y_index;
        this.regeneration = regeneration;
    }

    @Override
    public void newIndex(int newY, int newX) {
        this.x_index = newX;
        this.y_index = newY;
    }

    /*
    @Override
    public void setMove(){
        this.move = false;
    }
    */
    @Override
    public boolean getMove(){
        return move;
    }
    @Override
    public void setMove(boolean value){
        this.move = value;
    }
    @Override
    public String getType() {
        return type;
    }
    @Override
    public int getX_index() {
        return x_index;
    }

    @Override
    public int getY_index() {
        return y_index;
    }

    @Override
    public int getStrength() {
        return strength;
    }
    public void setStrength(int power){ this.strength = power; }
    @Override
    public int getRange() {
        return range;
    }

    @Override
    public int getLuck() {
        return luck;
    }
    public void setLuck(int luck){ this.luck = luck; }
    @Override
    public int getHp() {
        return hp;
    }

    public void setHp(int change){ this.hp = change; }
    public void takeDMG(int strength, int level, int range, int luck){
        int amount = (strength+level)/(2);
        this.hp -= amount;
    }

    @Override
    public int getMaxHp() {
        return maxhp;
    }
    public void setMaxHp(int maxhp) {this.maxhp = maxhp;}
    @Override
    public int getLevel() {
        return level;
    }

    public void increaseLevel(){
        this.level++;
    }

    @Override
    public boolean getSword() {
        return has_sword;
    }
    public void setSword(boolean has_sword){this.has_sword = has_sword;}
    @Override
    public boolean getShield() {
        return has_shield;
    }
    public void setShield(boolean has_shield){this.has_shield = has_shield;}
    @Override
    public boolean getRegeneration(){
        return regeneration;
    }
    public void setRegeneration(boolean regen){this.regeneration = regen;}
}