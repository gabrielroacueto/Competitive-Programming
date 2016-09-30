import java.util.*;
import java.io.*;

public class PerfectNumber {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int newNumber = in.nextInt();
		while (newNumber != -1){
			checkPerfect(newNumber);
			newNumber = in.nextInt();
		}
	}

	public static void checkPerfect(int number){
		int sum = 1;
		String output = number + " = 1";
		for (int i = 2; i < (number / 2 + 1); i++){
			if (number % i == 0){
				sum += i;
				output += " + " + i;
			}
		}

		if (sum == number){
			System.out.println(output);
		} else {
			System.out.println(number + " is NOT perfect.");
		}

	}
}
