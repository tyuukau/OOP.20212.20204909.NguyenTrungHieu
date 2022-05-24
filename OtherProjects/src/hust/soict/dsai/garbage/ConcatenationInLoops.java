package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class ConcatenationInLoops {

	public static void main(String[] args) {
		try {
			String fileName = "/Users/nguyenhieu/Library/Mobile Documents/com~apple~CloudDocs/Downloads/ML-code/data/crawl_data/the-thao.txt";
			byte[] inputBytes = Files.readAllBytes(Paths.get(fileName));

			GarbageCreator garbage = new GarbageCreator();
			NoGarbage noGarbage = new NoGarbage();

			garbage.concat(inputBytes); // Print: Total running time for concatenation using String: 60158
			noGarbage.concatBuffer(inputBytes); // Print: Total running time for concatenation using StringBuffer: 19
			noGarbage.concatBuilder(inputBytes); // Print: Total running time for concatenation using StringBuilder: 8

		} catch (IOException e) {
			e.printStackTrace();
		}
	
		Random r = new Random(123);
        long start = System.currentTimeMillis();

        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println(System.currentTimeMillis() - start); // This prints roughly 400.

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println(System.currentTimeMillis() - start); // This prints roughly 2.

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sf.append(r.nextInt(2));
        }
        s = sf.toString();
        System.out.println(System.currentTimeMillis() - start); // This prints roughly 4.        

		
	}

}
