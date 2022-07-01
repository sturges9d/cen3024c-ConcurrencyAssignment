/**
 * @author Stephen Sturges Jr
 * @version 06/30/2022
 */
package cen3024c;

import java.text.DecimalFormat;

public class TestClass {
	
	private static int count = 0;
	private static int currentIndex = 0;
	
	public static synchronized void sumIndexValue(int[] array, int arrayIndex) {
		count += array[arrayIndex];
	}
	
	public static synchronized void incrementIndex() {
		currentIndex++;
	}
	
	/**
	 * The main method.
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 200000000;
		int lowerBound = 1;
		int upperBound = 10;
		int[] randomArray = RandomIntegerArray.generateRandomArray(n, lowerBound, upperBound);
		singleThreadSumTimed(randomArray);
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (currentIndex < randomArray.length) {
					sumIndexValue(randomArray, currentIndex);
					incrementIndex();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (currentIndex < randomArray.length) {
					sumIndexValue(randomArray, currentIndex);
					incrementIndex();
				}
			}
		});

		long startTime = System.nanoTime();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		DecimalFormat df = new DecimalFormat("###,###,###");
		System.out.println("Multi-thread:\n\tElapsed time = " + df.format(elapsedTime) + " ns\n\tSum = " + df.format(count) + " (Possible range: 200,000,000 - 2,000,000,000)");
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
		
		// TODO Scorekeeping:
//		long elapsedTimeMax;
//		long elapsedTimeMin;
		
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

} // End of TestClass.
