* This program calculates which pass is right for them when taking the NYC transit system taking into consideration the number of days they will be riding and the number of rides
 * Created by Wyatt Gonzalez
 * Code Academy Projects
 * ALL CODE WAS CREATED BY WYATT BASED ON GUIDELINES FROM CODE ACADEMY
 */

public class TransitCalculator {

	int numDays; //Stores the number of days a person will take the transit system
	int numRides; //Stores the number of rides a person will take on the transit system
	double PAYPERRIDE = 2.75; // price for a single pay per ride ticket
	double SEVENDAYPASS= 33.00; // price for a seven day unlimited ride pass 
	double THIRTYDAYPASS = 127.00; //price for a 30 day unlimited ride pass
	
	public TransitCalculator(int dayNum, int rideNum) {
		 numDays = dayNum;
		 numRides = rideNum;
	}
	
	public double unlimited7PricePerRide() { //method to determine the price per ride for a 7 day unlimited pass
		if(numDays<=7) { 
			return SEVENDAYPASS /numRides;
		}
		else { 
		double passQuant = Math.ceil(numDays / 7); 
		if(passQuant % 7 != 0) { //if passQuant % 7 is anything other than 0 we will need to add an extra pass for that weeks rides
			passQuant += 1;
		}
		double price = SEVENDAYPASS * passQuant; 
		return price / numRides; 
		}
	}
	
	public double payPerRidePricePerRide() { //method to determine if the pay per ride option is someone's best bet
		double price = (PAYPERRIDE * numRides)/numRides;
		return price;
		
	}
	
	public double thirtyDayPassPricePerRide() { // method to determine price per ride for a 30 day pass
		if(numDays<=30) {  
			return THIRTYDAYPASS / numRides;
		}
		else {
			double passQuant = Math.ceil(numDays/30); 
			if(passQuant % 30 != 0) { 
				passQuant += 1;
			}
			double price= THIRTYDAYPASS * passQuant; 
			return price / numRides; 
		}
		
	}
	
	public double[] getRidePrices() { //This method inserts your price per ride into an array to compare which price is best
		double[] fares = new double[3];
		fares[0] = payPerRidePricePerRide();
		fares[1] = unlimited7PricePerRide();
		fares[2] = thirtyDayPassPricePerRide();
		return fares;
	}
	
	public double payPerRideTotal() { //this method calculates the total you would pay with the pay-per-ride option
		double price = numRides * PAYPERRIDE;
		return price;
	}
	
	public double sevenDayPassTotal() { // this method calculates the total you would pay for the seven day pass option
		double passQuant = 0;
		if(numDays<=7) {
			return SEVENDAYPASS;
		}
		else {
			passQuant = Math.ceil(numDays/7);
			if(passQuant % 7 != 0) {
				passQuant += 1;
			}
			double total = passQuant * SEVENDAYPASS;
			return total;
		}
	}
	
	public double thirtyDayPassTotal() {// this method calculates the total what you would pay for the thirty day pass option
		double passQuant = 0;
		if(numDays<=30) {
			return THIRTYDAYPASS;
		}
		else {
			passQuant = Math.ceil(numDays/30);
			if(passQuant % 30 !=0) {
				passQuant += 1;
			}
			double total = passQuant * THIRTYDAYPASS;
			return total;
		}
			
	}
	
	public String getBestFare() { //this method determines the best price per ride and then lets you know what the most cost effective option is and gives you the total you would spend
		
		double[] getRidePrices = getRidePrices();
		double bestFare = getRidePrices[0];
		
		for(int i=0;i<getRidePrices.length;i++){
				if(bestFare>getRidePrices[i]) {
					bestFare = getRidePrices[i];
				}
			}
		if(bestFare == getRidePrices[0]) {
			return "Your best option is to Pay-per ride at: $"+bestFare+" per ticket for a total of: $"+payPerRideTotal();
		}
		else if(bestFare == getRidePrices[1]) {
			return "Your best option is to buy the unlimted 7 day pass at : $"+bestFare+" per ticket for a total of: $"+sevenDayPassTotal();
		}
		else if(bestFare == getRidePrices[2]) {
			return "Your best option is to buy the unlimted 30 day pass at : $"+bestFare+" per ticket for a total of: $"+thirtyDayPassTotal();
		}
		else
			return "Whoops! Error!";
	}
	
	
	
	public static void main(String[] args) {
		
		TransitCalculator one = new TransitCalculator(165,500);
		TransitCalculator two = new TransitCalculator(20,40);
		TransitCalculator three = new TransitCalculator(1,5);
		System.out.println(one.getBestFare());
		System.out.println(two.getBestFare());
		System.out.println(three.getBestFare());

	}
}
