package swmaestro.q4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int []pad;
    private static int []isVisited;
    private static int cnt;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        pad=new int[n+1];
        isVisited=new int[n+1];
        for(int i=1;i<=n;i++){
            pad[i]=sc.nextInt();
        }

        cnt=0;
        Arrays.fill(isVisited,0);
        func(1);
        int t1=cnt;

        cnt=0;
        Arrays.fill(isVisited,0);
        func(2);
        int t2=cnt;

        Arrays.fill(isVisited,0);
        cnt=0;
        func(3);
        int t3=cnt;
    }

    public static void func(int num){
        if(isVisited[num]>1){
            System.out.println(cnt);

        }
        else{
           isVisited[num]++;
           cnt++;
           func(pad[num]);
        }
    }
}
