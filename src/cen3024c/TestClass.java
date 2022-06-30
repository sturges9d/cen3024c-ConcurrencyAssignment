package cen3024c;

import java.util.Random;

public class TestClass {

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
	
	/**
	 * The main method.
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 200000000;
		int n1 = 100;
		int[] randomArray = generateRandomArray(n);
		singleThreadSumTimed(randomArray);
		
	} // End of main.
	
	/**
	 * Times the execution of the sumArray method.
	 * @param array
	 */
	public static void singleThreadSumTimed(int[] array) {
		long startTime = System.nanoTime();
		int result = sumArray(array);
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		System.out.println("Single thread: Elapsed time = " + elapsedTime + " ns, Sum = " + result);
	} // End of singleThreadSumTimed.
	
	/**
	 * Sums the elements of an integer array.
	 * @param array
	 * @return
	 */
	public static int sumArray(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		} // End of for loop.
		return result;
	} // End of sumArray.

} // End of TestClass.
