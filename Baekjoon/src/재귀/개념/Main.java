package 재귀.개념;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int cur=0;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        int result=fibo(0,1);
        System.out.println(result);
    }
    public static int fibo(int a,int b){
        if(cur<n-2){
            int c=a+b;
            a=b;
            b=c;
            cur++;
            return fibo(a,b);

        }
        else
            return a+b;
    };
}
