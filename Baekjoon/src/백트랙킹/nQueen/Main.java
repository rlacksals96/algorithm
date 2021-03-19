package 백트랙킹.nQueen;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int n;
    private static boolean [][]isUsed;
    private static int cnt=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        isUsed=new boolean[3][];
        isUsed[0]=new boolean[n*2+1];//걍 넉넉하게 할당한거임.
        isUsed[1]=new boolean[n*2+1];
        isUsed[2]=new boolean[n*2+1];
        for (boolean[] booleans : isUsed) Arrays.fill(booleans, false);
        func(0);
        System.out.println(cnt);
    }
    //cur은 y를 의미함. y+1 해가면서 x값 되는 경우 체크한거임.
    public static void func(int cur){
        if(cur==n) {
            cnt++;
            return;
        }
        for(int i=0;i<n;i++){
            if(isUsed[0][i] || isUsed[1][cur+i] || isUsed[2][cur-i+n-1]){
                continue;
            }
            isUsed[0][i]=true;//가로
            isUsed[1][cur+i]=true;//세로
            isUsed[2][cur-i+n-1]=true;//대각선
            func(cur+1);
            isUsed[0][i]=false;
            isUsed[1][cur+i]=false;
            isUsed[2][cur-i+n-1]=false;
        }
    }
}
