package Week3;

/**
 * x 的平方根
 */
public class Leetcode_69_0256 {
    public static int mySqrt(int x) {
        if (x==0 || x==1 ) {
            return x;
        }

        long left = 1;
        long right = x / 2;
        while(left < right) {
            long mid = left + right + 1 >>> 1;
            if (mid * mid > x) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }

        return (int)left;
    }

    public static boolean isPerfectSquare(int num) {
        int s = mySqrt(num);
        return s*s == num;
    }


    public static void main(String[] args) {
        int s = mySqrt(2147395599);
        System.out.println(s);
    }
}
