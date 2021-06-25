package phone;


	public class Galaxy extends Phone implements Ringable {
	    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
	        super(versionNumber, batteryPercentage, carrier, ringTone);
	    }
	
	    @Override
	    public String unlock() {
	        return "unlock using password";
	    }
	 
		@Override
		public String Ring() {
			
			return this.getRingTone();
		}
		
		   @Override
		    public void displayInfo() {
			      System.out.println("Version Number: " + this.getVersionNumber());
			      System.out.println("Batter Percentage: " + this.getBatteryPercentage());
			      System.out.println("Carrier: " + this.getCarrier());
			      System.out.println("RingTone: " + this.getRingTone());
			    }
		                   
		    }
	



