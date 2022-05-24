package hust.soict.dsai.garbage;

public class GarbageCreator {
	public void concat(byte[] inputBytes) {
		long startTime = System.currentTimeMillis();
		String outputString = "";
		for (byte b: inputBytes) {
			outputString += (char)b;
		}
		// StringBuilder outputStringBuilder = new StringBuilder();
		// for (byte b: inputBytes) {
		// 	outputStringBuilder.append((char)b);
		// }
		long endTime = System.currentTimeMillis();
		System.out.println("Total running time for concatenation using String: " + (endTime - startTime));
	}
	
}
