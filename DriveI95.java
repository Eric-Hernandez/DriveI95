import java.util.Scanner;
//=============================================================================
public class DriveI95 {
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    private static final double SPEED_LIMIT = 65;
//-----------------------------------------------------------------------------
	public static void main(String[] args) {

//----Variables to hold speed, time, distance, and boolean
		double speed, time, distance;
		double restTime, travelTime;
		boolean speeding;


//----User messages
		System.out.println("Welcome to the I95 Speed Machine");
		System.out.println();
		System.out.println();
		System.out.println("You will have to supply: ");
		System.out.println("+ The distance you want to travel, in miles");
		System.out.println("+ The time you have available, in hours");
		System.out.println();
		System.out.println();

//----Input distance and time
		System.out.print("Enter distance to travel : ");
		distance = keyboard.nextDouble();
		System.out.print("Enter time available     : ");
		time = keyboard.nextDouble();

		restTime = computeRestTime(distance);
		travelTime = computeTravelTime(time, restTime);
		speed = computeSpeed(distance, travelTime);

//----Display outputs
		speeding = speed > SPEED_LIMIT;
		System.out.println();
		System.out.println("You will have to travel at " + speed +" MPH");
		System.out.println("Over the speed limit     : " + speeding);

		}

//-----------------------------------------------------------------------------
//----Compute time for stops
	private static double computeRestTime(double distance) {

		double restStop = distance / 100;

//----If there is a remainder from the division, 1 one must be added to answer
		if ((distance % 100) != 0) {
			restStop = Math.ceil(restStop);
		}

		double restTime = ((restStop * 5)/60);
		return restTime;
}
//-----------------------------------------------------------------------------
//----Compute time for travel
	private static double computeTravelTime(double time, double restTime) {

		double travelTime = time - restTime;
		return travelTime;
}
//-----------------------------------------------------------------------------
//----Compute speed
	private static double computeSpeed(double distance, double travelTime) {

		double speed = distance/ travelTime;
		return speed;

}
//-----------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------
