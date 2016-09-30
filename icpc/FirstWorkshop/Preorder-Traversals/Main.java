/***
First wrong attemp:
	Try to do this without checking ALL numbers after i
	
Pseudocode:
Before Main method:
	declase a global casenumber.

	Main method
		Create array list and handle input.
		Submit each arraylist to our checkPreorderProp method.

	checkPreorderProp method
		For all elements in the array i.
		Go through the rest of the array and find a number greater than i.
		If any number after that number greater than i is less than i, then the tree is invalid.

***/

import java.util.*;
import java.io.*;

public class Main {
	private static int caseNumber = 1;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		int getInput = in.nextInt();
		intArray.add(getInput);
		while (in.hasNextInt()){
			getInput = in.nextInt();
			if (getInput >= 0){
				intArray.add(getInput);
			} else {
				if (checkPreorderProp(intArray)){
					System.out.println("Case " + caseNumber + ": yes");
					caseNumber++;
				} else {
					System.out.println("Case " + caseNumber + ": no");
					caseNumber++;
				}
				intArray = new ArrayList<Integer>();
			}
		}


	}

	public static boolean checkPreorderProp(ArrayList<Integer> intArray){
		//For each array, if intArray[n] < intArray[n + 1], then any int array[>n] must be less than n.
		for (int i = 0; i < intArray.size() - 1; i++){ //i goes from 0 to last index - 1.
			for (int j = i + 1; j < intArray.size() - 1; j++){
				if (intArray.get(i) < intArray.get(j)){
					for (int k = j + 1; k < intArray.size(); k++){
						if (intArray.get(i) >= intArray.get(k)){
							return false;
						}
					}
				}
			}
		}


		return true;
	}


}
