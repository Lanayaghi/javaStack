
public class Wizard extends Human {
	private int health = 50;
	private int intelligence = 8;

public void heal(Human po) {
	po.health += this.intelligence;
}
public void fireball(Human po) {
	po.health -= (this.intelligence*3);
	
}
}
