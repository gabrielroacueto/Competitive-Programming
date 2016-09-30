import java.io.*;
import java.util.*;
public class Positive {
	private static Scanner in;
	private static PrintWriter writer;
	public static void main(String[] args){
		try {
			in = new Scanner(new File("input.txt"));
			writer = new PrintWriter("output.txt", "UTF-8");

			while (in.hasNextLine()){
				writer.println(returnMagic(in.nextLine()));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		writer.close();
	}

	public static String returnMagic(String dataset){
		String[] split = dataset.split(" ");
		double[] set = new double[4];
		double ret = -1;
		boolean isArithmetric;
		boolean isGeometric;
		double hasDecimal;

		for (int i = 0; i < 4; i++){
			set[i] = Double.parseDouble(split[i]);
		}

		//Four cases:
		//-1 is first
		if (set[0] == -1){
			isArithmetric = (((set[2] - set[1]) + set[2]) == set[3]);
			isGeometric = (((set[2] / set[1]) * set[2]) == set[3]);
			if (isArithmetric) {
				//System.out.println("Arithmetric sequence");
				ret = (set[1] - (set[2] - set[1]));
			} else if (isGeometric){
				//System.out.println("Geometric sequence");
				ret = (set[1] / (set[2] / set[1]));
			}
		}

		//-1 is second
		if (set[1] == -1){
			isArithmetric = ((set[3] - set[2]) * 2) + set[0] == set[2];
			isGeometric = (Math.pow(set[3] / set[2], 2) * set[0] == set[2]);
			
			if (isArithmetric){
				//System.out.println("Arithmetric");
				ret = ((set[3] - set[2]) + set[0]);
			} else if (isGeometric){
				//System.out.println("Geometric");
				ret = ((set[3] / set[2]) * set[0]);
			}
		}
		//-1 is third
		if (set[2] == -1){
			isArithmetric = ((set[1] - set[0]) * 2) + set[1] == set[3];
			isGeometric = (Math.pow(set[1] / set[0], 2) * set[1] == set[3]);

			if (isArithmetric){
				ret = (set[1] - set[0]) + set[1];
			} else if (isGeometric) {
				ret = (set[1] / set[0]) * set[1];
			}
		}
		//-1 is fourth
		if (set[3] == - 1){
			isArithmetric = ((set[1] - set[0]) + set[1]) == set[2];
			isGeometric = ((set[2] / set[1]) * set[0]) == set[1];

			if (isArithmetric){
				ret = (set[1] - set[0]) + set[2];
			} else if (isGeometric){
				ret = (set[1] / set[0]) * set[2];
			}
		}
		
		if (ret <= 1 || (ret % 1) != 0 || ret > 10000){
			ret = -1;
		}

		return Integer.toString((int)ret);
	}
}