package dynamicProgramming.타일01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int []d;
    public static void main(String[] args) throws IOException {
        d=new int[1000000+1];
        d[0]=0;
        d[1]=1;
        d[2]=2;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        for(int i=3;i<=n;i++) {
            d[i] = d[i - 1] + d[i - 2];
            d[i]%=15746;
        }

        System.out.println(d[n]);
    }

}
