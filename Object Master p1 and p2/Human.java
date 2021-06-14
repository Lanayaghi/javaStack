public class Human {
	public int strength = 3;
	public int stealth = 3;
	public int intelligence  = 3;
	public int health  = 100;
	


public Human (int strength, int stealth, int intelligence, int health) {
	this.strength = strength;
	this.stealth = stealth;
	this.intelligence = intelligence;
	this.health = health;
}
	
public Human() {
	// TODO Auto-generated constructor stub
}

public int attack(Human po) {
	po.health -= this.strength;
	return po.health;
}


}
