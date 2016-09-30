import java.util.*;
import java.io.*;


public class SortMe {

	private static char[] CurrentAlphabet = new char[26];

	public static void main(String[] args){
		String[] wordList = new String[20];
		Map<Character, Integer> map = new HashMap<Character, Integer>();

    try {
      Scanner in = new Scanner(System.in);
  		String newLine = in.nextLine();
      int count = 1;
  		while(!newLine.equals("0")){
        System.out.println("year " + count);
  			String[] inputSplit = newLine.split(" ");
  			int wordAmount = Integer.parseInt(inputSplit[0]);
  			int addThis = 2;
  			if (wordAmount >= 10){
  				addThis = 3;
  			}
  			for (int i = 0; i < 26; i++){
  				map.put(newLine.charAt(i + addThis), i);
  			}
  			for (int i = 0; i < wordAmount; i++){
  				wordList[i] = in.nextLine();
  			}
        //System.out.println(wordList[3]);
        //System.out.println(map.get('V'));
  			sortWordList(wordList, map, wordAmount);
  			wordList = new String[20];
  			map = new HashMap<Character, Integer>();
        count++;
        newLine = in.nextLine();
  		}
    } catch (Exception e){
      e.printStackTrace();
    }

	}

	private static void sortWordList(String[] wordList, Map<Character, Integer> map, int size){
		for( int i = 0; i < size; i++){

			for (int j = 0; j < size; j++){


				if (!isBigger(wordList[i], wordList[j], map)){

					String temp = wordList[i];
					wordList[i] = wordList[j];
					wordList[j] = temp;

				}

			}

		}
		//System.out.println("Sorted list: " );
		for (int i = 0; i < size; i++){

			System.out.println(wordList[i]);
		}
	}

	private static boolean isBigger(String word1, String word2, Map<Character, Integer> map){

		boolean retVal = false;
		boolean isSmaller = false;
		int shorterLength = 0;
		if (word1.length() <= word2.length()){
			shorterLength = word1.length();
		} else {
			shorterLength = word2.length();
		}

		for (int i = 0; i < shorterLength; i++){
      //System.out.println(word1);
			int current1 = map.get(word1.charAt(i));
			int current2 = map.get(word2.charAt(i));

			if (current1 > current2){
				retVal = true;
				break;
			} else if (current2 > current1){
				isSmaller = true;
				break;
			}
		}

		if (!retVal && !isSmaller){

			if (word1.length() > word2.length()){
				return true;
			} else if (word2.length() >= word1.length()){
				return false;
			}

		}

		return retVal;




	}
}
