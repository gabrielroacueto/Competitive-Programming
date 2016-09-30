import java.io.*;
import java.util.*;

public class Boggle {
	private static String[][] grid;
	private static String[] wordList;
	private static String[][] tempGrid;
	public static void main(String[] args){
		//args[0] will be the amount of words..
		//args[1] will be word 1, 2 3 etc...
		try {
			Scanner in = new Scanner(new File("input.txt"));
			int wordAmount = Integer.parseInt(in.nextLine()); //Amount of words.
			wordList = new String[wordAmount];

			String[] words = new String[wordAmount];

			for (int i = 0; i < wordAmount; i++){
				wordList[i] = in.nextLine();
			}

			while(in.hasNextLine()){
				String newLine = in.nextLine();
				int gridSize;
				if (newLine.equals("0")){
					break;
				} else {
					gridSize = Integer.parseInt(newLine);
					grid = new String[gridSize][gridSize];

					for(int i = 0; i < gridSize; i++){
						grid[i] = in.nextLine().split("");
						
					}
					System.out.println("Created a " + gridSize + "x" + gridSize + " grid.");
					for (int m = 0; m < gridSize; m++){
						for (int n = 0; n < gridSize; n++){
							System.out.print(grid[m][n] + " ");
						}
						System.out.println();
					}
					System.out.println("Running look up words.");
					lookUpWords(grid, wordList);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		

	}

	public static void lookUpWords(String[][] grid, String[] list){
		System.out.println("Lookup words started.");
		for (int i = 0; i < list.length; i++){
			tempGrid = grid;
			System.out.println("Passing " + list[i] + " as argument for find letter.");
			findLetter(list[i]);

		}
	}

	public static void findLetter(String word){
		System.out.println("findLetter started with " + word);
		String[][] tempGrid = grid;
		boolean wordFound = false;
		boolean letterNotFound = false;
		String[] letters = word.split("");
		System.out.println("Got a word that is " + letters.length + " characters long.");
		//check left

		//Search grid for first letter.
		//If the first letter is found check surroundings for each of the remaining letters.
		//If one of the remaining letters is not found then look for the first letter again in
		//the rest of the grid.
		//If you find the first letter check it's surrounding for each of the remaining letters.
		//If you find each of the remaining letters print out the word.

		for(int i = 0; i < tempGrid.length; i++){
			for (int j = 0; j < tempGrid[i].length; j++){
				if (tempGrid[i][j].equals(letters[0])){

					// Check surroundings returns an array of two integers, which is 
					// the coordinates where the letter passed was found (So it takes the letter and
					// coordinates surrounding it.)

					//Because the coordinates of the first letter are in terms of i & j,
					//you might need to check those first, and then check in terms of firstLetter[0], firstLetter[i]
					//Either way you have to constantly update the coordinates.

					//So define this: 
					int[] coords = new int[2];
					coords[0] = j;
					coords[1] = i;

					//Now for every letter you'll pass on those values and update them
					//properly.
					surroundingloop:
					for(int k = 1; k < letters.length; k++){

						coords = checkSurroundings(letters[k], coords[0], coords[1]);
							//So if the letter was not foudn in the surroundings:
						if (coords[0] == -1){
							//Find a way to break out of the loop and look for the first
							//letter again until it runs out of grid...

							//This will break out of the current for loop
							letterNotFound = true;
							break surroundingloop;
						}
					}

			

					//This will continue to search the first letter in the grid.
					if (letterNotFound){
						letterNotFound = false;
						continue;
					//Else if you succesfully ran the loop and found every letter
					//Log the word.
					} else {
						wordFound = true;
						System.out.println(word);
						break;
					}

					//Now find a way to exit if the whole word was not found. Or do you?
				}
			}
		}

		//This is the end of the for loop for searching the grid.
		//check right
	}

	public static int[] checkSurroundings(String letter, int x, int y){
		
		int[] ret = new int[2];
		//check left
		if (x != 0){
			if (grid[y][x - 1].equals(letter)){
				System.out.println("to the left");
				x -= 1;
				ret[0] = x;
				ret[1] = y;
				return ret;
			}
		}

		//check right
		if (x != tempGrid.length - 1){
			if (grid[y][x + 1].equals(letter)){
				System.out.println("to the right");
				x += 1;
				ret[0] = x;
				ret[1] = y;
				return ret;
			}

		}

		//check up
		if (y != 0){
			if (grid[y - 1][x].equals(letter)){
				System.out.println("To the up");
				y -= 1;
				ret[0] = x;
				ret[1] = y;
				return ret;
			}

		}

		//check down
		if (y != tempGrid.length - 1){
			if (grid[y + 1][x].equals(letter)){
				System.out.println("To the down");
				y += 1;
				ret[0] = x;
				ret[1] = y;
				return ret;
			}
				
		}

		//check up left
		if (y != 0 && x != 0){
			if (grid[y - 1][x - 1].equals(letter)){
				System.out.println("To the up and left");
				y -= 1;
				x -= 1;
				ret[0] = x;
				ret[1] = y;
				return ret;
			}
		}

		//check up right
		if (y != 0 && x != tempGrid.length - 1){
			if (grid[y - 1][x + 1].equals(letter)){
				System.out.println("To the up and right");
				y -= 1;
				x += 1;
				ret[0] = x;
				ret[1] = y;
				return ret;
			}
		}

		//check down left
		if (y != tempGrid.length - 1 && x != 0){
			if (grid[y + 1][x - 1].equals(letter)){
				System.out.println("To the down and to the left");
				y += 1;
				x -= 1;
				ret[0] = x;
				ret[1] = y;
				return ret;
			}
				
		}

		//check down right
		if (y != tempGrid.length - 1 && x != tempGrid.length - 1){
			if (grid[y + 1][x + 1].equals(letter)){
				System.out.println("To the down and right.");
				y += 1;
				x += 1;
				ret[0] = x;
				ret[1] = y;
				return ret;
			}
		}

		System.out.println("Not found mothafucka");
		ret[0] = -1;
		ret[1] = -1;
		return ret;




	}


}