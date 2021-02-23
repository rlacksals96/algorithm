package dynamicProgramming.파도반수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
* 결과값의 크기가 커서 intㄹ 커버하지 못하는 경우도 종종 존재한다. (특히 문제에선 값의 범위를 정확히 안알려주는 경우가 많으므로 결과값을
* 담는 경우에 대해선 왼만하면 long 같은 큰 자료형을 쓰는것이 좋을거 같다.)
* */
public class Main {
    private static long []p=new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int []input=new int[t];



        for(int i=0;i<t;i++)
            input[i]=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            long ans=func(input[i]);
            System.out.println(ans);
        }


    }
    public static long func(int n){
        p[1]=1;
        p[2]=1;
        p[3]=1;
        p[4]=2;
        p[5]=2;
        if(n<6)
            return p[n];
        for(int i=6;i<=n;i++)
            p[i]=p[i-1]+p[i-5];
        return p[n];
    }
}
