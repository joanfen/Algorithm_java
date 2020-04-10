package Week3;

public class Fibonacci {
    public static int fib(int N) {
        // terminator
        if ( N == 0) return 0;
        if ( N == 1) return 1;
        return fib(N-1) + fib(N-2);

    }

//    public int count(int N, int result)

    public static void main(String[] args) {
        System.out.println(fib(8));
    }

}
