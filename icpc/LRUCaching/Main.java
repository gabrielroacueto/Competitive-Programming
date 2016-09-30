import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;

class Main{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		int stage = 1;
		while(input.hasNext()){

			int cacheSize = input.nextInt();
			if(cacheSize == 0){
				break;
			}//end if

			System.out.println("Simulation " + stage);

			String access = input.next();
			simulateAccess(cacheSize, access);

			stage++;
		}//end while

	}//end main

	public static void simulateAccess(int cacheSize, String access){

		int length = access.length();
		LinkedList<String> cache = new LinkedList<String>();

		for(int accessCounter = 0; accessCounter < length; accessCounter++){

			String currentLetter = Character.toString(access.charAt(accessCounter));
			if(currentLetter.equals("!")){
				ListIterator<String> iterator = cache.listIterator(0);
				for(;iterator.hasNext();){
					System.out.print(iterator.next());
				}//end for
				System.out.println();
			}//end if
			else{

				if(cache.contains(currentLetter)){
					cache.remove(currentLetter);
					cache.add(currentLetter);
				}//end if
				else{ //does not contain, must check if already max cache
					if(cache.size() == cacheSize){
						cache.remove(0);
						cache.add(currentLetter);
					}//end if
					else{
						cache.add(currentLetter);
					}//end else


				}//end else

			}//end else


		}//end for loop

	}//end method simulateAccess
}//end class Caching