import java.util.ArrayList;
import java.util.List;

/**
 * Created by justin on 2/16/2016.
 */
public class Player implements ISaveable {

    private String name;
    private int health;
    private int strength;
    private String weapon;


    public Player(String name, int health, int strength, String weapon) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.weapon = weapon;
    }

    public Player(){
        this.name = "Unknown";
        this.health = 20;
        this.strength = 20;
        this.weapon = "Wooden sword";
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getStrength() {
        return this.strength;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }


    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, this.name);
        values.add(1, "" + this.health);
        values.add(2, "" + this.strength);
        values.add(3, "" + this.weapon);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size()>0) {
            this.name = savedValues.get(0);
            this.health = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
            this.weapon = savedValues.get(3);
        }
    }

    public void loseHealth(int damage) {
        this.health = this.health - damage;
        if(this.health <= 0) {
            System.out.println("Player knocked out.");
            // reduce number of lives remaining for the player
        }
    }

    public int healthRemaining() {
        return this.health;
    }
}
