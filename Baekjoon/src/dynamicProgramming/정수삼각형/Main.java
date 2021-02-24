package dynamicProgramming.정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    private static int [][]input;
    private static int n;
    private static int [][]d;
    private static ArrayList<Integer> resultArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        resultArray=new ArrayList<>();

        n=Integer.parseInt(br.readLine());
        input=new int[n][];
        d=new int[n+1][n+1];
        for(int i=0;i<n;i++)
            input[i]=new int[i+1];

        String []str=new String[n];
        for(int i=0;i<n;i++){
            str[i]=br.readLine();
        }
        for(int i=0;i<n;i++){
            String []tmp=str[i].split(" ");
            for(int j=0;j<tmp.length;j++){
                input[i][j]=Integer.parseInt(tmp[j]);
            }
        }


//        func(0,0,0);
        d[0][0]=input[0][0];
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0)
                    d[i][j]=d[i-1][j]+input[i][j];
                else if(i==j)
                    d[i][j]=d[i-1][j-1]+input[i][j];
                else
                    d[i][j]=Math.max(d[i-1][j-1],d[i-1][j])+input[i][j];
            }
        }

        int max=0;
        for(int i=0;i<d[n-1].length;i++)
            if(max<d[n-1][i])
                max=d[n-1][i];

        System.out.println(max);

    }

    //func(0,0,0) 로 호출하면 재귀적으로 해결하는건데 그렇게 되면 메모리 초과 뜸.. 결과는 맞음..
    public static void func(int res,int level,int idx){
        if(level==n){
            resultArray.add(res);
            return;
        }
        res+=input[level][idx];
        func(res,level+1,idx);
        func(res,level+1,idx+1);
    }
}
