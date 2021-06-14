
public class Samurai extends Human {
	public int health = 200;
	static int count=0;
	
	public Samurai(){
		count++;
		
	}
public void deathBlow(Human po) {
	po.health = 0;
	health =health /2;
}

public void meditate() {
	health += health/2;
}

public int howMany() {
	return count;
	
}
}
