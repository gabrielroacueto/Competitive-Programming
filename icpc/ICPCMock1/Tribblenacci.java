import java.io.*;
import java.util.*;

public class Tribblenacci {

	public static long[] genValues = new long[68];

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 68; i++){
			genValues[i] = -1;
		}
		long numberCases = in.nextLong();
		for (int i = 0; i < numberCases; i++){
			System.out.println(tribble(in.nextInt()));
		}
	}

	public static long tribble(int genNumber){
		if (genNumber < 2){
			return 1;
		} else if (genNumber == 2){
			return 2;
		} else if (genNumber == 3){
			return 4;
		} else {
			if (genValues[genNumber] != -1){
				return genValues[genNumber];
			} else {
				genValues[genNumber] = tribble(genNumber - 1) + tribble(genNumber - 2) + tribble(genNumber - 3)
					+ tribble(genNumber - 4);
				return genValues[genNumber];

			}
		}
	}
}
