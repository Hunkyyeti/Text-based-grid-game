//Imports the java util library
import java.util.Scanner;

class Scan {
	public static double getDub(){
		// scans for, stores, and outputs a double
		Scanner scan = new Scanner(System.in);
		return scan.nextDouble();
	}// double
	public static String getStr(){
		// scans for, stores, and outputs a string
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}// string
}// Scan