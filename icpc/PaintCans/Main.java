import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        while(in.hasNextLine()){
            int aptNum = in.nextInt();
            int width = in.nextInt();
            int length = in.nextInt();
            int height = in.nextInt();
            double area = in.nextDouble();
            int m = in .nextInt();
            
            if (aptNum == 0 && width == 0){
                System.exit(0);
            }
            
            int[][] dimensions = new int[m][2];
            for (int i = 0; i < m; i++){
                
                
                int dim1 = in.nextInt();
                int dim2 = in.nextInt();
                dimensions[i][0] = dim1;
                dimensions[i][1] = dim2;
                
            }
            
            double cansNeeded = aptNum *  ( (paintNoDoors(width, length, height) - paintDoors(dimensions)) / area);
            //System.out.println(cansNeeded);
            System.out.println((int)Math.ceil(cansNeeded));
            
            
            
            
        }
        
    }
    
    static double paintNoDoors(int width, int length,int height){
        int ceiling = length * width;
        int wall = width * height * 2;
        int otherWall = length * height * 2;
        
        return (ceiling + wall + otherWall);
    }
    
    static double paintDoors(int[][] dimensions){
        int totalSum = 0;
        for (int i = 0; i < dimensions.length; i++){
            totalSum += dimensions[i][0] * dimensions[i][1];
        }
        return totalSum;
    }
}