package 백트랙킹.MandN_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int m,n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[9];
        dfs(0);
    }
    public static void dfs(int idx){
        if(idx==m){
            for(int i=0;i<m-1;i++){
                if(arr[i]>arr[i+1])
                    return;
            }

            for(int i=0;i<m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++){
            arr[idx]=i;
            dfs(idx+1);
        }
    }
}
