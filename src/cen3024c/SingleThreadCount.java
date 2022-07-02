package cen3024c;

import java.text.DecimalFormat;

public class SingleThreadCount {

	static int runCount = 0;
	
	/**
	 * Times the execution of the sumArray method.
	 * @param array
	 */
	public static void singleThreadSumTimed(int[] array) {
		long startTime = System.nanoTime();
		int result = sumArray(array);
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		DecimalFormat df = new DecimalFormat("###,###,###");
		System.out.println("Single-thread:\n\tElapsed time = " + df.format(elapsedTime) + " ns\n\tSum = " + df.format(result) + " (Possible range: 200,000,000 - 2,000,000,000)");
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
	
} // End of singleThreadCount class.
