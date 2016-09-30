import java.io.*;
import java.util.*;

public class CompareText {
	public static void main(String[] args){
		int line = 0;
		try{
			Scanner results = new Scanner(new File(args[0]));
			Scanner test = new Scanner(new File(args[1]));

			while(results.hasNextLine() && test.hasNextLine()){
				line++;
				if (!results.nextLine().equals(test.nextLine())){
					System.out.println(line + " False");
				} else {
					System.out.println("Passed");
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}