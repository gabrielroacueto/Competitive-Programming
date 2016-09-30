/***
First not working attemps:
  Trying to get all primes without using Math.sqrt() property takes too long.
  Trying to compute the actual factorials (50 factorial is already outside the scope of a long,
  let alone 100,000).
  Forgetting to get the set's size.


Pseudocode:
Before main function:
  Create a map of Integers to an ArrayList. This map will map each integer to it's prime decomposition. 6 --> [2, 3]
  Create an arraylist of Integers with a method getPrimesLess which gets every prime number less than 100,000

  Main method
    Call fillMap function that fills our decomposed map.

    Handle input.
    Handle otput.

  getPrimesLess method
    Use the property for getting primes fast by only trying divisions of n <= Math.sqrt(number)

  fillMap method
    map.put(The number, decompose method to decompose the number. This method returns a list)

  decompose method
    This method returns a list with all the prime decompositions of a number.
    While the number is less than 1,
      get me the minimal prime divisor and add it to the list.
      divide the number by our minimal prime divisor.

    return list.

  get minimalPrimeDivisor method
    For all numbers in our prime list, start from the bottom and get the first number that mods to 0.
    return it.

***/

//6796.pdf - 2014 South Central

import java.util.*;
import java.io.*;

public class Main {
  public static Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
  public static ArrayList<Integer> primesLessThan = getPrimesLess();
  public static void main(String[] args){


    fillMap();
    Scanner in = new Scanner(System.in);
    int caseNumber = in.nextInt();
    for (int i = 0; i < caseNumber; i++){
      getOutput(in.nextInt());
    }
  }


  public static void getOutput(int number){
    int totalSize = 0;
    int setSize = 0;
    Set<Intenger> removeDups = new HashSet<Integer>();

    for (int i = 2; i <= number; i++){
      totalSize += map.get(i).size();
      removeDups.addAll(map.get(i));
    }

    setSize += removeDups.size();
    System.out.println(setSize + " " + totalSize);

  }


  public static ArrayList<Integer> getPrimesLess(){
    ArrayList<Integer> myTable = new ArrayList<Integer>();
    boolean current = true;
    myTable.add(2);
    for (int i = 3; i <= 100000; i++){

      for (int j = 2; j <= Math.sqrt(i); j++){
        if (i % j == 0){


          current = false;
        }
      }

      if (current){


        myTable.add(i);
      }

      current = true;
    }

    return myTable;
  }


  public static void fillMap(){
    ArrayList<Integer> currentList = new ArrayList<Integer>();
    for (int i = 2; i <= 100000; i++){
      map.put(i, decompose(i));

    }
  }


  public static ArrayList<Integer> decompose(int n){

    ArrayList<Integer> returnList = new ArrayList<Integer>();
    while (n > 1){
      returnList.add(minimalPrimeDivisor(n));
      n /= minimalPrimeDivisor(n);
    }

    return returnList;
  }


  public static int minimalPrimeDivisor(int n){

    for(int i = 0; i < primesLessThan.size(); i++){
      if (n % primesLessThan.get(i) == 0){
        return primesLessThan.get(i);
      }
    }

    return n;
  }


}
