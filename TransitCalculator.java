
public class TransitCalculator {

	int numDays;
	int numRides;
	double PAYPERRIDE = 2.75;
	double SEVENDAYPASS= 33.00;
	double THIRTYDAYPASS = 127.00;
	
	public TransitCalculator(int dayNum, int rideNum) {
		 numDays = dayNum;
		 numRides = rideNum;
	}
	
	public double unlimited7Price() { //something seems to be wrong with this method
		if(numDays<=7) {
			return SEVENDAYPASS /numRides;
		}
		else {
		double passQuant = Math.ceil(numDays / 7); 
		double price = SEVENDAYPASS * passQuant;
		return price / numRides;
		}
	}
	
	public double payPerRidePrice() { 
		double price = PAYPERRIDE * numRides;
		return price;
		
	}
	
	public double thirtyDayPassPrice() {
		if(numDays<=30) {
			return THIRTYDAYPASS / numRides;
		}
		else {
			double passQuant = Math.ceil(numDays/30);
			double price= THIRTYDAYPASS * passQuant;
			return price / numRides;
		}
		
	}
	
	public double[] getRidePrices() {
		double[] fares = new double[3];
		fares[0] = payPerRidePrice();
		fares[1] = unlimited7Price();
		fares[2] = thirtyDayPassPrice();
		return fares;
	}
	
	public String getBestFare() {
		
		double bestFare = getRidePrices()[0];
		
		for(int i=0;i<getRidePrices().length;i++){
				if(bestFare>getRidePrices()[i]) {
					bestFare = getRidePrices()[i];
					
				}
			
			}
		if(bestFare == getRidePrices()[0]) {
			return "Your best option is to Pay-per ride at: "+bestFare+" per ticket";
		}
		else if(bestFare == getRidePrices()[1]) {
			return "Your best option is to buy the unlimted 7 day pass at :"+bestFare+" per ticket";
		}
		else if(bestFare == getRidePrices()[2]) {
			return "Your best option is to buy the unlimted 30 day pass at :"+bestFare+" per ticket";
		}
		else
			return "Whoops! Error!";
	}
	
	
	
	public static void main(String[] args) {
		
		TransitCalculator one = new TransitCalculator(29,100);
		TransitCalculator two = new TransitCalculator(1,11);
		TransitCalculator three = new TransitCalculator(1,5);
		System.out.println(one.getBestFare());
		System.out.println(two.getBestFare());
		System.out.println(three.getBestFare());
		

	}
}
