package cn.com.pzliu.recursion;

/**
 * 求阶乘
 */
public class Factorial {

    public long cal(int n){

        if (n < 0){
            throw new IllegalArgumentException("传入参数错误");
        }

        if (n == 0){
            return 1;
        }

        return n * cal(n - 1);
    }


    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.cal(0));
        System.out.println(factorial.cal(1));
        System.out.println(factorial.cal(3));
        System.out.println(factorial.cal(10));
    }

}
