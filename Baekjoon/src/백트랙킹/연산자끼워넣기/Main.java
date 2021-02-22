package 백트랙킹.연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int []num;
    private static int []oper;
    private static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        n=Integer.parseInt(br.readLine());
        num=new int[n];
        result=new ArrayList<>();
        oper=new int[4];
        String []input=br.readLine().split(" ");
        for(int i=0;i<num.length;i++)
            num[i]=Integer.parseInt(input[i]);

        String []input2=br.readLine().split(" ");
        for(int i=0;i< oper.length;i++)
            oper[i]=Integer.parseInt(input2[i]);

        func(1,num[0]);

        Collections.sort(result);
        System.out.println(result.get(result.size()-1));
        System.out.println(result.get(0));

    }
    //midRes -> mid result
    //idx -> 입력값 배열의 idx
    public static void func(int idx,int midRes){
        if(idx==num.length){
            result.add(midRes);
            return;
        }

        if(oper[0]!=0){
            oper[0]--;
            midRes+=num[idx];
            func(idx+1,midRes);
            oper[0]++;
            midRes-=num[idx];
        }
        if(oper[1]!=0){
            oper[1]--;
            midRes-=num[idx];
            func(idx+1,midRes);
            oper[1]++;
            midRes+=num[idx];
        }
        if(oper[2]!=0){
            oper[2]--;
            midRes*=num[idx];
            func(idx+1,midRes);
            oper[2]++;
            midRes/=num[idx];
        }
        if(oper[3]!=0){
            oper[3]--;
            midRes/=num[idx];
            func(idx+1,midRes);
            oper[3]++;
            midRes*=num[idx];
        }

    }
}
