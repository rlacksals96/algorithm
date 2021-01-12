package 재귀.팩토리얼;

import java.util.Scanner;

public class Main {

    public static int factorial(int n){
        if(n==0)
            return 1;
        else
            return n*factorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        if(!(0<=N && N<=12))
            throw new IllegalArgumentException();
        System.out.println(factorial(N));
    }
}
