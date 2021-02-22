package 백트랙킹.스타와링크;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int [][]s;
    private static int sum=0;
    private static int min;
    private static boolean []isPicked;
    private static ArrayList<Integer> team1;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        team1=new ArrayList<>();

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
//            System.out.println(team1.toString());
            calcStat(team1);
            return;
        }
        for(int i=num;i<=n;i++){
            if(!isPicked[i]){
                isPicked[i]=true;
                team1.add(i);
                combination(cnt+1,i+1);
                team1.remove(team1.size()-1);
                isPicked[i]=false;
            }
        }
    }

    public static void calcStat(ArrayList<Integer> team){
       Integer []arr=team.toArray(new Integer[0]);
       int stat1=0;
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr.length;j++) {
                stat1 += s[i][j];
            }
        }
        int stat2=sum-stat1;
        if(min>Math.abs(stat1-stat2))
            min=Math.abs(stat1-stat2);
    }
}
