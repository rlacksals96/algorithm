package 백트랙킹.MandN_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//중복 허용하지 않고, 배열이 오름차순으로 가야하기 때문에 시작값을 이전의 값보다 크게 잡아야 한다.
public class Main {
    private static int N,M;
    private static int []arr;
    private static boolean []isUsed;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[9];//selected element
        isUsed=new boolean[9];
        Arrays.fill(isUsed,false);

        dfs(1,0);

    }
    public static void dfs(int num,int cnt){
        if(cnt==M){
            for(int i=0;i<M;i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }

        for(int i=num;i<=N;i++){
            if(!isUsed[i]){
                isUsed[i]=true;
                arr[cnt]=i;
                dfs(i+1,cnt+1);
                isUsed[i]=false;

            }
        }
    }
}
