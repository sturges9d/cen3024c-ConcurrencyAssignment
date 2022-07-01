/**
 * @author Stephen Sturges Jr
 * @version 07/01/2022
 */
package cen3024c;

public class MultiThreadCount implements Runnable {

	private int[] array;
	private int arrayIndex;
	private int currentCount;
	
	public MultiThreadCount(int[] array) {
		this.array = array;
	} // End of MultiThreadCount constructor.
	
	public synchronized void addArrayIndexValue(int[] array, int arrayIndex, int currentCount) {
		this.currentCount = currentCount + array[arrayIndex];
	} // End of addArrayIndexValue method.
	
	public synchronized void incrementIndexValue(int arrayIndex) {
		this.arrayIndex = arrayIndex++;
	} // End of getCurrentArrayIndexValue method.
	
	@Override
	public void run() {
		
	} // End of run method.
	
} // End of MultiThreadCount class.
