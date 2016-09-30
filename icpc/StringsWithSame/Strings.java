import java.util.*;
import java.io.*;

public class Strings{

	public static int[] compare = new int[26];
	public static int[] toThis = new int[26];
	public static int currentCase = 0;

	public static void main(String[] args){
		try {
			Scanner in = new Scanner(new File("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("home.txt")));

			while (in.hasNextLine()){
				String input = in.nextLine();
				String against = in.nextLine();
				currentCase++;
				if (input.equals("END")){
					break;
				} else {

					if (compareStrings(input, against)){
						System.out.println("Case " + currentCase + ": same");
					} else {
						System.out.println("Case " + currentCase + ": different");
					}
				}




			}


		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public static boolean compareStrings(String input, String against){

		if (input.length() == against.length()){

			for (int i = 0; i < input.length(); i++){
				//System.out.println(input.charAt(i));
				compare[input.charAt(i) - 97]++;
			}

			for (int i = 0; i < against.length(); i++){

				toThis[against.charAt(i) - 97]++;
			}

			for (int i = 0; i < 26; i++){
				if (compare[i] != toThis[i]){
					toThis = new int[26];
					compare = new int[26];
					return false;
				}
			}

			toThis = new int[26];
			compare = new int[26];
			return true;


		} else {
			toThis = new int[26];
			compare = new int[26];
			return false;
		}


	}


}
