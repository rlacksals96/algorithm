package 백트랙킹.MandN_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//java의 경우 시간 초과 뜨나, 같은 방식으로 c++로 리팩토링 해서 사용시 통과됨.....

//중복 허용하는 수열이기 때문에 별도의 isUsed[] 가 필요 없음.
public class Main {

    private static int m,n;
    private static int []arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new int[8];


        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());//length m


        dfs(0);

    }
    public static void dfs(int idx){
        if(idx==m){
            for(int i=0;i<m;i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++) {

            arr[idx] = i;
            dfs(idx + 1);
        }
    }
}
