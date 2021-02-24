package dynamicProgramming.계단오르기;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []input=new int[301];
        int []d=new int[301];

        for(int i=0;i<n;i++)
            input[i]=sc.nextInt();

        d[0]=input[0];
        d[1]=Math.max(input[0]+input[1],input[1]);
        d[2]=Math.max(input[0]+input[2],input[1]+input[2]);

        //경우의 수
        //? ? o o  -> ? o x o o
        //? o  x o
        for(int i=3;i<n;i++){
            d[i]=Math.max(d[i-2]+input[i],d[i-3]+input[i-1]+input[i]);
        }
        System.out.println(d[n-1]);
    }
}
