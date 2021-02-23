package 백트랙킹.스타와링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int [][]s;
    private static int sum=0;
    private static int min;
    private static boolean []isPicked;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        isPicked=new boolean[n+1];
        Arrays.fill(isPicked,false);
        s=new int[n][];
        for(int i=0;i<s.length;i++) {
            s[i] = new int[n];
        }

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
                sum+=s[i][j];
            }
        }
        min=sum;//init min
        combination(0,1);
        System.out.println(min);
    }
    //cnt 뽑인 수
    //num 뽑힌 사람 번호 1~n 까지 사용
    public static void combination(int cnt,int num){
        if(cnt==n/2){
           int[] sum=new int[2];
           for(int i=0;i<n;i++){
               for(int j=0;j<n;j++){
                   if(i==j)
                       continue;
                   if(isPicked[i] && isPicked[j])
                       sum[0]+=s[i][j];
                   if(!isPicked[i] && !isPicked[j])
                       sum[1]+=s[i][j];
               }
           }
           min=Math.min(min,Math.abs(sum[0]-sum[1]));
        }
        for(int i=num;i<n;i++){
            if(!isPicked[i]){
                isPicked[i]=true;
                combination(cnt+1,i);
                isPicked[i]=false;
            }
        }
    }


}
