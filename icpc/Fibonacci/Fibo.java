public class Fibo {

	public static int[] fiboArray = new int[1000];

	public static void main(String[] args){
		for (int i = 0; i < fiboArray.length; i++){
			fiboArray[i] = -1;
		}
		int get = fibo(Integer.parseInt(args[0]));
		System.out.println("Fibonacci is " + get);
	}

	public static int fibo(int n){
		if (fiboArray[n] == -1){
			if (n < 2){
				fiboArray[n] = 1;
			} else {
				fiboArray[n] = fibo(n - 1) + fibo(n - 2);
			}
		}

		return fiboArray[n];
	}
}


/***
Is 4 less than 2?
No... 
return fibo(3) + fibo(2)
is 3 less than 2?
return fibo(2) + fibo(1)
fibo(1) + fibo(0)
*/


