import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int pancakeAmount = in.nextInt();
			int[] pancakes = new int[pancakeAmount];
			if (pancakeAmount == 0){
				break;
			} else {
				for (int i = 0; i < pancakeAmount; i++){
					pancakes[i] = pancakeAmount;
				}

				int[] flips = flip(pancakes);

				for (int i : flips){
					System.out.print(i + " ");
				}

				System.out.println();
			}
		}
	}

	static int[] flip(int[] pancakes){

		for (int i = 0; i < pancakes; i++){
			if (pancakes[i] > pancakes[i + 1]){

			}
		}

	}
}