import java.io.*;
import java.util.*;
import java.math.*;
public class Palindrome {
	private static BigInteger currentDec = new BigInteger("0");
	private static final BigInteger TEN = new BigInteger("10");
	public static void main(String[] args){
		//Each line read after the first one is a number.
		try {
			Scanner in = new Scanner(new File("input.txt"));
			String runInteger = in.nextLine();
			while (in.hasNextLine()){
				runInteger = in.nextLine();
				System.out.println(getPalin(runInteger));
			}

		} catch (Exception e){
			e.printStackTrace();
		}
		
		
	}

	public static String getPalin(String number){
		while(!checkPalin(number)){
			BigInteger bigNumber = new BigInteger(number);
			bigNumber = bigNumber.add(currentDec);
			//System.out.println(bigNumber);
			number = bigNumber.toString();
			//System.out.println("Incrementing." + number);
			
		}

		return number;

	}

	public static boolean checkPalin(String number){
		String[] array = number.split("");
		int j = array.length - 1;
		for (int i = 0; i < (array.length / 2) + 1; i++){
			if (!array[i].equals(array[j])){
				//BigInteger exp = new BigInteger(Integer.toString(i));

				
				if (Integer.parseInt(array[i]) < Integer.parseInt(array[j])){
					currentDec = TEN.pow(j);
				} else {
					currentDec = TEN.pow(i);
				}
				return false;
			}


			if (j <= i)
				break;

			j--;
		}

		return true;

	}


}