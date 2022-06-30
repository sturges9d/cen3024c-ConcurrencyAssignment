/**
 * @author Stephen Sturges Jr
 * @version 06/30/2022
 */
package cen3024c;

import java.util.Random;

public class GenerateRandArrayInt {
	
	/**
	 * Outputs the contents of an integer array in the terminal.
	 * @param array Integer array to be displayed.
	 * @param rowLength Integer controlling how many elements of the array are output in a row.
	 */
	public static void displayArrayInColumnRow(int[] array, int rowLength) {
		// Display column numbers.
		for (int i = 0; i <= rowLength; i++) {
			if (i == 0) {
				System.out.print("Column:\t");
			} else if (i == rowLength) {
				System.out.println(i);
			} else {
				System.out.print(i + "\t");
			} // End of if-else block.
		} // End of for loop.
		
		// Display row numbers followed by array elements.
		int j = 1;
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				System.out.print("Row " + j + ":\t" + array[i] + ",\t");
				j++;
			} else if(i % rowLength == 0) {
				System.out.print("\nRow " + j + ":\t" + array[i] + ",\t");
				j++;
			} else {
				System.out.print(array[i] + ",\t");
			} // End of if-else block.
		} // End of for loop.
	} // End of displayArrayInColumnRow.
	
	/**
	 * Outputs the contents of an integer array in the terminal.
	 * @param array Integer array to be displayed.
	 * @param rowLength Integer controlling how many elements of the array are output in a row.
	 */
	public static void displayArrayInColumnRowDebug(int[] array, int rowLength) {
		// Display column numbers.
		for (int i = 0; i <= rowLength; i++) {
			if (i == 0) {
				System.out.print("Column:\t");
			} else if (i == rowLength) {
				System.out.println(i);
			} else {
				System.out.print(i + "\t");
			} // End of if-else block.
		} // End of for loop.
		
		// Display row numbers followed by array elements.
		int j = 1;
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				System.out.print("Row " + j + ":\t" + i + "," + array[i] + ",\t");
				j++;
			} else if (i % rowLength == 0) {
				System.out.print("\nRow " + j + ":\t" + i + "," + array[i] + ",\t");
				j++;
			} else {
				System.out.print(i + "," + array[i] + ",\t");
			} // End of if-else block.
		} // End of for loop.
	} // End of displayArrayInColumnRowDebug.
	
	/**
	 * Outputs the contents of an array in the console.
	 * @param array
	 */
	public static void displayArraySimple(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + ": " + array[i]);
		} // End of for loop.
	} // End of displayArraySimple.
	
	/**
	 * Generates an array of random numbers
	 * @param numberOfRandomNumbers Integer representing the number of elements in the array.
	 * @return An array of random integers.
	 */
	public static int[] generateRandomArray(int numberOfRandomNumbers) {
		int[] randomIntArray = new int[numberOfRandomNumbers];
		Random random = new Random();
		
		for (int i = 0; i < (numberOfRandomNumbers); i++) {
			randomIntArray[i] = random.nextInt(1, 10);
		} // End of for loop.
		
		return randomIntArray;
	} // End of generateRandomArray.
	
} // End of GenerateRandArrayInt class.
