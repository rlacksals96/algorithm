package swmaestro.q3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//당콩 수
        int m=sc.nextInt();//ㅁ먹을 갯수
        int e=sc.nextInt();//소마 위치
        int []peanut=new int[n];

        for(int i=0;i<peanut.length;i++)
            peanut[i]=sc.nextInt();
        Arrays.sort(peanut);


    }
}
