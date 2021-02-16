package 백트랙킹.MandN_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int[] arr;
    private static boolean[] isUsed;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[10];
        isUsed=new boolean[10];
        Arrays.fill(isUsed,false);

        func(0);
    }
    public static void func(int k) {
        if(k==M){
            for(int i=0;i<M;i++)
                System.out.print(arr[i]+" ");
            System.out.println();
        }
        for(int i=1;i<=N;i++){
            if(!isUsed[i]){
                arr[k]=i;
                isUsed[i]=true;
                func(k+1);

                isUsed[i]=false;
            }
        }
    }
}
