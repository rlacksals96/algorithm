package 재귀.피보나치;

import java.util.Scanner;

public class Main {
    private int cur=0;
    private final int N;
    public Main(int N){
        this.N=N;
    }
    public int fibonacci(int a1,int a2){
        if(cur<N-2){
            int a3=a1+a2;
            a1=a2;
            a2=a3;
            cur++;
            return fibonacci(a1,a2);
        }
        else
            return a1+a2;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        if(!(0<=N&&N<=20))
            throw new IllegalArgumentException();
        Main m=new Main(N);
        if(N<2)
            System.out.println(N);
        else
            System.out.println(m.fibonacci(0,1));
    }
}
