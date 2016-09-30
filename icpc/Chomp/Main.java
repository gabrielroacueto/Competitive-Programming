import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int caseAmount = in.nextInt();
    for (int i = 0; i < caseAmount; i++){
      int caseNumber = in.nextInt();
      int bottom = in.nextInt();
      int middle = in.nextInt();
      int top = in.nextInt();

      System.out.println(caseNumber + " " + solveChomp(bottom, middle, top));
    }
  }

  public static String solveChomp(int bottom, int middle, int top){
    return "this";
  }
}
