import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()){
			int i = in.nextInt();
			int j = in.nextInt();
			System.out.println(i + " " + j + " " + getMaxCycle(i , j));
		}
	}

	static int getMaxCycle(int i, int j){
		int max = -1;
		int current = -1;
		for (int k = i; k <= j; k++){
			current = getCycle(k);
			System.out.println(current);
			max = max < current ? current : max;
		}
		return max;
	}

	static int getCycle(int n){
		int nCount = 1;
		do {
			if (n % 2 == 0){
				n = n / 2;
			} else {
				n = n * 3 + 1;
			}
			nCount++;

		} while (n != 1);

		return nCount;
	}
}
