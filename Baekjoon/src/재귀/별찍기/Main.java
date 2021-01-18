package 재귀.별찍기;

import java.util.Arrays;
import java.util.Scanner;

//어려움.. 다시 분석 필요...
//작동 원리에 대해서는 이해 했으나 좌표와 관련하여 헤깔리는 부분이 많음. (y,x)꼴로 뒤집어서 표현하는게
//맞는거 같긴 한데 좀더 이해 필요하고, 인자로 다음과 같이 줘야 옳은 답이 나오는지에 대한 이해도 필요..
public class Main{
    public static char [][]mat;

    public static void solve(int y,int x,int num){
        if(num==1){
            mat[y][x]='*';
            return;
        }
        int div=num/3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==1 && j==1)
                    continue;
                else
                    solve(y+(i*div),x+(j*div),div);
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        mat=new char[n][n];
        for(int i=0;i<mat.length;i++)
            Arrays.fill(mat[i],' ');
        solve(0,0,n);
        for(int i=0;i<mat.length;i++)
            System.out.println(mat[i]);

//        for(int i=0;i<mat.length;i++){
//            for(int j=0;j<mat[0].length;j++)
//                System.out.print(mat[i][j]);
//            System.out.println();
//        }
    }
}