import java.util.*;
import java.io.*;

//Different hands will return a string describing them.

public class Poker {

	public static String[] allCards = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
	public static String[] allRanks = {"S", "C", "D", "H"};
	public static int highestRank;
	public static PrintWriter writer;
	public static Scanner in;

	public static void main(String[] args){

		try {
			in = new Scanner(new File("input.txt"));
			writer = new PrintWriter("output.txt", "UTF-8");
			in.nextLine();

			while (in.hasNextLine()){
				writer.println(returnWinner(in.nextLine(), in.nextLine()));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		writer.close();
	}

	//Another idea is to return an array of two integers, the second one would be the highest ranking card.
	public static int[] checkOne(String hand){ //Check one returns if No pairs, One Pair, Two pairs, triple, Full house or four of a kind
		String[] handArray = hand.split(" ");
		int[] cardCounts = new int[14];
		int[] flushCount = new int[4];
		int pairCount = 0;
		boolean isFlush = false;
		boolean isTriple = false;
		int pairHighest = 0;

		for (int i = 0; i < 5; i++){			//Compare the numbers to all the cards and at them to an array of counts.
			for (int j = 0; j < 14; j++){
				if (handArray[i].substring(0, 1).equals(allCards[j])){
					cardCounts[j]++;
				}

				if (j < 4){
					if (handArray[i].substring(1, 2).equals(allRanks[j])){
						if (flushCount[j] == 4){ 
							//check for royal
							isFlush = true;
						} else {
							flushCount[j]++; //Flush count is useless if it never reaches 5.
						}

					}
				}
			}
		}

		for (int  i =0; i < 14; i++){

			//Check if a five consecutive sum can get to 5.
			int straightSum = 0;
			straightSum += cardCounts[i];
			if (cardCounts[i] == 1){
				for (int j = i + 1; j < i + 5; j++){
					if (j < 14 && cardCounts[j] == 1){
						straightSum += cardCounts[j];


						if (straightSum == 5 || (straightSum == 4 && cardCounts[13] ==  1 && cardCounts[2] == 1)){ //If you find 5 consecutive card counts -- If you find four starting from 2 and there is an ace..
							if (isFlush){
								if (cardCounts[13] == 1){
									int[] ret = {9, 0};
									return ret; //Royal flush;
								} else {
									int[] ret = {8, j};
									return ret; //Straight flush
								}
							} else {
								int[] ret = {4, j};
								return ret; //Just straight
							}
						} 
					} else {
						continue;
					}
				
					

				}
			}
			


			straightSum = 0;


			if (cardCounts[i] == 2){
				pairHighest = i;
				pairCount++;
			} else if (cardCounts[i] == 3){
				//highestRank = i;
				pairHighest = i;
				isTriple = true;
			} else if (cardCounts[i] == 4){
				//highestRank = i;
				int[] ret = {7, i};
				return ret;	//Its Four of Kind
			}
		}

		//After you do a four loop through the cards and checks and everything... If you havent returned anything.
		if (isFlush){
			int[] ret = {5, 0};
			return ret; //Flush
		}else if (pairCount == 1 && isTriple){
			int[] ret = {6, pairHighest};
			return ret;	//Is  a full house
		} else if (pairCount == 1){
			int[] ret = {1, pairHighest};
			return ret;	//Is one pair
		} else if (pairCount == 2){
			int[] ret = {2, pairHighest};
			return ret; //Two pairs
		} else if (pairCount == 0 && isTriple){
			int[] ret = {3, pairHighest};
			return ret; //Triple
		} else {
			int[] ret = {0, 0};
			return ret; //No pairs
		}

	}
	
	public static int checkRank(String hand1, String hand2){
		//Check all and return the highest rank of both strings.
		String[] hand1Array = hand1.split(" ");
		String[] hand2Array = hand2.split(" ");
		int[] cardCounts1 = new int[14];
		int[] cardCounts2 = new int[14];

		for (int i = 0; i < 5; i++){			//Compare the numbers to all the cards and at them to an array of counts.
			for (int j = 0; j < 14; j++){
				if (hand1Array[i].substring(0, 1).equals(allCards[j])){
					cardCounts1[j]++;
				}

				if (hand2Array[i].substring(0, 1).equals(allCards[j])){
					cardCounts2[j]++;
				}
			}
		}

		for(int i = 13; i >= 0; i--){
			if (cardCounts1[i] > cardCounts2[i]){
				return 1;
			} else if (cardCounts1[i] < cardCounts2[i]){
				return 2;
			}
		}

		return 0;

	}


	public static String returnWinner(String hand1, String hand2){
		int[] hand1one = checkOne(hand1);
		int[] hand2one = checkOne(hand2);

		if (hand1one[0] > hand2one[0]){
			return hand1;
		} else if (hand2one[0] > hand1one[0]){
			return hand2;
		} else {
			if (hand1one[0] == 0 || hand1one[0] == 5 || hand1one[0] == 1 || hand1one[0] == 2){
				if (checkRank(hand1, hand2) == 1){
					return hand1;
				} else if (checkRank(hand1, hand2) == 2){
					return hand2;
				} else {
					return "Tie";
				}
			} else {
				if (hand1one[1] > hand2one[1]){
					return hand1;

				} else if (hand1one[1] < hand2one[1]){

					return hand2;

				} else {
					return "Tie";
				}

			}

		}
	}
	
}


/* 
If numbers are the same then do a rank check.
RF  9
SF  8
FK  7
FH  6
F   5
S   4
T   3
TP  2
OP	1
NP	0		Check if flush (check if royal), check if straight
*/