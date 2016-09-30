import java.io.*;
import java.util.*;

public class Hanoi {

  public static long currentKth;
  public static long kCounter = 0;
  public static String[] moveArray;

  public static void main(String[] args){

    Scanner in = new Scanner(System.in);
    currentKth = in.nextLong();
    moveArray = new Array[currentKth + 1];
    long nth = in.nextLong();
    System.out.println("Running case: ");
    move(nth, "A", "B", "C");

  }

  public static void move(long n, String start, String aux, String end){
    //System.out.println("Increasing " + kCounter);
    //System.out.println("Comparing " + kCounter + " to " + currentKth);
    if (n == 1){
      kCounter++;
      if (kCounter == currentKth){
        System.out.println(n + " " + start + " " + end);
      }
    } else {
      //System.out.println("N is not equal to 1");
      move(n - 1, start, end, aux);
      //System.out.println("But " + kCounter + " != to " + currentKth );
      kCounter++;
      if (kCounter == currentKth){
        System.out.println(n + " " + start + " -> " + end);
      }
      move(n - 1, aux, start, end);
    }
  }
}
