package cen3024c;

public class MultithreadSum implements Runnable {
	
	public static synchronized void addElapsedTime(long time) {
		TestClass.elapsedTime += time;
	} // End of addElapsedTime method.
	
	public static synchronized void countArray() {
		TestClass.count += TestClass.randomArray[TestClass.arrayIndex];
	} // End of countArray method.
	
	public static synchronized void incrementArrayIndex() {
		TestClass.arrayIndex++;
	} // End of incrementArrayIndex method.
	
	@Override
	public void run() {
		long startTime = System.nanoTime();
		while(TestClass.arrayIndex < TestClass.sizeOfArray) {
			countArray();
			incrementArrayIndex();
		} // End of while loop.
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		addElapsedTime(elapsedTime);
	} // End of run method.
	
}
