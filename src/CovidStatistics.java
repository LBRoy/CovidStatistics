
/**
 * <p>The CovidStatistics class is used for printing patient count information for multiple provinces and months across Canada.</p>
 * <p> It will display the the amount of patients per month for specific months and provinces.</p>
 * <p> It also prints out the average amount of patients per province, rounded to the nearest integer</p>
 * 
 * <p>Exceptions:</p>
 * <p> If a programmer changes the values of the 2-D array and inputs a letter, decimal, or any other character
 *  other than a integer, it will produce an error.</p>
 * <p> If a value of the 2-D array for patients is bigger than 2147483647 it will produce an error[1].</p>
 * <p> If programmer does not change the final values for ROWS or COLUMNS but adds more indexes to the array
 * the program will not print all of the values.</p>
 * 
 * @author Braden Howard
 */

public class CovidStatistics
{
    /**
     * @param args (not used)
     */
public static void main(String[] args)
 {
   final int ROWS = 7;
   final int COLUMNS = 8;

   // 2D array for patients
   int[][] patients = 
      { 
         {  2200, 1100, 1200, 1000, 1015, 2000, 1092, 2204 },
         {  5020, 6105, 2009, 9047, 1016, 2014, 2708, 2308 }, 
         {  1720, 2406, 3054, 1018, 1023, 3100, 1406, 1502 }, 
         {  1490, 2002, 2016, 5008, 2044, 1055, 1607, 2201 },
         {  1520, 1007, 1092, 2065, 1023, 1010, 1046, 1502 },
         {  1670, 1201, 2008, 2001, 1086, 1009, 1041, 1706 },
	 {  1870, 2001, 2078, 1006, 1053, 1702, 1009, 1406 }
         
      };

   String[] provinces = 
      { 
         "Ontario", 
         "Quebec", 
         "Nova Scotia",
         "New Brunswick", 
         "Manitoba", 
         "British Columbia",
	     "Prince Edward Island"         
      };
   

   System.out.println("              Month      Feb     March   April   May     June    July    Aug     Sept    Avg");
   System.out.println();

   // Referenced Oracle to learn how 2-D arrays work, references at bottom of code[2].
   for (int i = 0; i < ROWS; i++) {// Outer for loop prints provinces
	   System.out.printf("%21s",provinces[i]);// Left padding to match sample output
	   
	   for (int j = 0; j < COLUMNS; j++) {// Inner for loop prints each column(patients each month), row by row
		   System.out.printf("%8d",patients[i][j]);// Left padding of each column of numbers printed
	   }
	   // Initialize averageOfRow to equal aveByProvince(patients, i)
	   int averageOfRow = aveByProvince(patients, i);// Calls aveByProvince
	   System.out.printf("%8d", averageOfRow);// Prints average of each row
	   System.out.println();
   }

   
   System.out.println();
   System.out.printf("%22s", "Recovered Patients"); // Fixed spacing to match CovidSample
   
   // Calculates the sum of each column in the 2D array (patients) and prints the column sum.
   for (int j = 0; j < COLUMNS; j++) {   
   int sumOfColumn = 0; // Initializes sumOfColumn to 0 to reset for each column
	   for (int i = 0; i < ROWS; i++) {   	   
		   sumOfColumn = sumOfColumn + patients[i][j]; // Adds each row per column to get the sum of the column
	   }
	   System.out.printf("%8d",sumOfColumn); // Print the column sum, padded to 8 characters to match the sample output file
   }
 
   
   System.out.println("\n"); 
   System.out.println(); 
   

   System.out.printf("%60s", "Vaccinate and maintain good health practices!" ); 
 }
/**
 * This method returns the average of patients per province represented as an int. 
 * @param patients The 2-D array named patients, information used to get average per row
 * @param ROWS Row of the 2-D array for the patients
 * @return averageOfRow Returns average of patients for each row
 */
 public static int aveByProvince(int[][] patients, int ROWS) {
     double sumOfRow = 0;// Initializing sumOfRow to 0
     for (int i = 0; i < patients[ROWS].length; i++){  	 
             sumOfRow = sumOfRow + patients[ROWS][i];// Adds each row to get total sum
     		}
     double averageOfRow = sumOfRow / patients[ROWS].length;// divides sumOfRow by length of patients to get average
     // Referenced Educative.io for Math.round, references at bottom of code[3].
     averageOfRow = Math.round(averageOfRow);// Rounds averageOfRow since its a double 
     return (int) averageOfRow;// Cast to int from double
 	}
 }
/*
 * References:
 * In the Javadoc comment above the class I used the information about how large an integer could be from CodeGym.cc.
 * [1] Integer.MAX_VALUE in Java with Examples.  CodeGym.cc 
 * https://codegym.cc/groups/posts/integermax_value-in-java-with-examples (accessed Jun. 03, 2023).
 * 
 * Used the provided link to: Oracle, Arrays, from the hybrid to learn how 2-D arrays work.
 * [2] Arrays. Oracle.com
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html (accessed Jun. 3, 2023).
 * 
 * Used a method taken from Educative.io to round a double to a integer.
 * [3] How to use the java math.round() method. Educative.io
 *  https://www.educative.io/answers/how-to-use-the-java-mathround-method (accessed Jun. 3, 2023). 
 */

