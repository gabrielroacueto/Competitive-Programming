public class RecursiveFibo {
	public static void main(String[] args){
		System.out.println("Fibonacci is: " + fibo(Integer.parseInt(args[0])));
	}

	public static int fibo(int n){
		if (n < 2){
			return 1;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}

	}
}