import java.util.concurrent.ThreadLocalRandom;

public class Humans {
    Goblins goblin = new Goblins();
    private int strength = ThreadLocalRandom.current().nextInt(8, 30);
    private int stamina;
    private String name;
    private String color;
    private int health=100;

    private int[] cords ={7,7};
    public Humans(){

    }
    public Humans(String name, int health, int strength, int stamina, int[] cords){
        this.strength = strength;
        this.stamina = stamina;
        this.name = name;
        this.health = health;
        this.cords = cords;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int[] getCords() {
        return cords;
    }

    public void setCords(int[] cords) {
        this.cords = cords;
    }

    public void attack(){
        while (health>0 && goblin.getHealth()>0){
            goblin.setHealth(goblin.getHealth()-strength);
            setHealth(getHealth()-goblin.getStrength());
            System.out.println("Player health "+health);
            System.out.println("Player strength "+strength);
            System.out.println("Goblin health "+goblin.getHealth());
            System.out.println("Goblin strength " +goblin.getStrength());
        }
        goblin.setHealth(30);
        goblin.setStrength(ThreadLocalRandom.current().nextInt(8,30));
    }

    @Override
    public String toString(){
        return "Human";
    }
}
