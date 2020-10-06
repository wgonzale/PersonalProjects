
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
		int passQuant = Math.round(numDays / 7);
		double price = SEVENDAYPASS * passQuant;
		return price / numRides;
	}
	
	public double[] getRidePrices() {
		double[] fares = new double[3];
		fares[0] = PAYPERRIDE * numRides;
		fares[1] = unlimited7Price();
		fares[2] = THIRTYDAYPASS / numRides;
		return fares;
	}
	
	public String getBestFare() {
		
		double bestFare = getRidePrices()[0];
		
		for(int i=0;i<getRidePrices().length;i++){
			{
				if(bestFare<getRidePrices()[i]) {
					bestFare = getRidePrices()[i];
				}
			}
		}
		if(bestFare == getRidePrices()[0]) {
			return "You should get the Pay-per-ride option at: $"+Math.round(bestFare*100.0)/100+" per ride";
		}
		else if(bestFare == getRidePrices()[1]) {
			return "You should get the 7-day unlimited ride option at: $"+Math.round(bestFare*100.0)/100+" per ride";
		}
		else if(bestFare == getRidePrices()[2]) {
			return "You should get the 30-day unlimited ride option at: $" +Math.round(bestFare*100.0)/100+" per ride";
		}
		else {
			return "Oops something went wrong here";
		}
	}
	
	public static void main(String[] args) {
		
		TransitCalculator one = new TransitCalculator(29,76);
		TransitCalculator two = new TransitCalculator(1,5);
		TransitCalculator three = new TransitCalculator(7,32);
		System.out.println(one.getBestFare());
		System.out.println(two.getBestFare());
		System.out.println(three.getBestFare());
		

	}
