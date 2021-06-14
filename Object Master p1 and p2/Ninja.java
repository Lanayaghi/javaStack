
public class Ninja extends Human {
	public int stealth  = 10;
	

	

	

public void steal(Human po) {
	po.stealth -= health;
	po.health += health;
	
}

public void runAway() {
   health = health - 10;
	
}

}
