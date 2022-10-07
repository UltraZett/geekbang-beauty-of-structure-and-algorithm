package cn.com.pzliu.recursion;

/**
 * 斐波那契数列
 */
public class Fibonacci {

    public long cal(int n){

        if (n == 1 || n == 2){
            return 1;
        }

        return cal(n - 1) + cal(n-2);
    }


    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.cal(1));
        System.out.println(fibonacci.cal(2));
        System.out.println(fibonacci.cal(9));
    }


}
