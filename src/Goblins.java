import java.util.concurrent.ThreadLocalRandom;

public class Goblins {
    private int strength = ThreadLocalRandom.current().nextInt(8, 30);
    private int stamina;
    private String name;
    private String color;
    private int health=30;

    private int[] cords;

    public Goblins(){

    }
    public Goblins(int strength, int stamina, String name, String color, int health, int[] cords){
        this.strength = strength;
        this.stamina = stamina;
        this.name = name;
        this.color = color;
        this.health = health;
        this.cords = cords;
    }

    public int getStrength() {
        return strength;
    }

    public int getStamina() {
        return stamina;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getHealth() {
        return health;
    }

    public int[] getCords() {
        return cords;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setCords(int[] cords) {
        this.cords = cords;
    }

    @Override
    public String toString(){
        return "Goblin";
    }
}
