package dynamicProgramming.피보나치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] d;
    private static int zero=0;
    private static int one=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
       d=new int[50];
        Arrays.fill(d,0);
        int []c=new int[t];

        for(int i=0;i<t;i++)
            c[i]=Integer.parseInt(br.readLine());

        int res;
        for (int j : c) {
            if(j==0){
                System.out.println("1 0");
                continue;
            }
            System.out.println(fibo(j-1)+" "+fibo(j));
        }


    }
    public static int fibo(int n){
        if(d[n]!=0)
            return d[n];
       if(n==0){
           zero++;
           d[0]=0;
           return d[n];
       }
       if(n==1){
           one++;
           d[1]=1;
           return d[n];
       }

       return d[n]=fibo(n-2)+fibo(n-1);
    }
}
