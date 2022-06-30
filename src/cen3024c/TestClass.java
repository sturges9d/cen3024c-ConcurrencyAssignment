/**
 * @author Stephen Sturges Jr
 * @version 06/30/2022
 */
package cen3024c;

public class TestClass {
	
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
		System.out.println("Single thread: Elapsed time = " + elapsedTime + " ns, Sum = " + result + "(200,000,000 - 2,000,000,000)");
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
