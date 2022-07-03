/**
 * @author Stephen Sturges
 * @version 07/03/2022
 */
package cen3024c;

import java.text.DecimalFormat;

public class TestClass {

	static int sizeOfArray = 200000000;
	static int lowerBound = 1;
	static int upperBound = 10;
	static int[] randomArray = RandomIntegerArray.generateRandomArray(sizeOfArray, lowerBound, upperBound);
	static int arrayIndex = 0;
	static int count = 0;
	static long elapsedTime = 0;
	
	
	
	public static void main(String[] args) {
		// Multithread method:
		// First thread.
		Thread t1 = new Thread(new MultithreadSum());
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Second thread.
		Thread t2 = new Thread(new MultithreadSum());
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DecimalFormat df = new DecimalFormat("###,###,###");
		System.out.println("Multi-thread:\n\tElapsed time = " + df.format(elapsedTime) + " ns\n\tSum = " + df.format(count) + " (Possible range: 200,000,000 - 2,000,000,000)");
		
		// Single thread method:
		SingleThreadCount.singleThreadSumTimed(randomArray);
		
	} // End of main method.

	

} // End of TestClass class.
