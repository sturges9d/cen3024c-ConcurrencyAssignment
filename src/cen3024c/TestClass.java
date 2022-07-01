package cen3024c;

import java.text.DecimalFormat;

public class TestClass implements Runnable {

	static int sizeOfArray = 200000000;
	static int lowerBound = 1;
	static int upperBound = 10;
	static int[] randomArray = RandomIntegerArray.generateRandomArray(sizeOfArray, lowerBound, upperBound);
	static int arrayIndex = 0;
	static int count = 0;
	static long elapsedTime = 0;
	
	public static synchronized void incrementArrayIndex() {
		arrayIndex++;
	} // End of incrementArrayIndex method.
	
	public static synchronized void countArray() {
		count = count + randomArray[arrayIndex];
	} // End of countArray method.
	
	public static void main(String[] args) {
		SingleThreadCount.singleThreadSumTimed(randomArray);
		Thread t1 = new Thread(new TestClass());
		long startTime = System.nanoTime();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread t2 = new Thread(new TestClass());
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		DecimalFormat df = new DecimalFormat("###,###,###");
		System.out.println("Multi-thread:\n\tElapsed time = " + df.format(elapsedTime) + " ns\n\tSum = " + df.format(count) + " (Possible range: 200,000,000 - 2,000,000,000)");
	} // End of main method.

	@Override
	public void run() {
		while(arrayIndex < sizeOfArray) {
			countArray();
			incrementArrayIndex();
		} // End of while loop.
	} // End of run method.

} // End of TestClass class.
