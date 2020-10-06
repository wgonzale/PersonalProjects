
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
	
	public double unlimited7Price() {
		if(numDays<=7) {
			return SEVENDAYPASS /numRides;
		}
		else {
		int passQuant = Math.round(numDays / 7);
		double price = SEVENDAYPASS * passQuant;
		return price / numRides;
		}
	}
	
	public double payPerRidePrice() {
		if(numDays >= 7)
		return PAYPERRIDE * numRides;
	}
	
	public double thirtyDayPassPrice() {
		if(numDays<=30) {
			return THIRTYDAYPASS / numRides;
		}
		else {
			int passQuant = Math.round(numDays/30);
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
				if(bestFare<getRidePrices()[i]) {
					bestFare = getRidePrices()[i];
				}
			
			}		
		return ("Best fare is: "+bestFare);
	}
	
	
	
	public static void main(String[] args) {
		
		TransitCalculator one = new TransitCalculator(29,76);
		TransitCalculator two = new TransitCalculator(1,5);
		TransitCalculator three = new TransitCalculator(7,32);
		System.out.println(one.getBestFare());
		System.out.println(two.getBestFare());
		System.out.println(three.getBestFare());
		

	}
}
