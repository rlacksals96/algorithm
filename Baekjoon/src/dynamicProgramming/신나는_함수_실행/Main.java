package dynamicProgramming.신나는_함수_실행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int a,b,c;
    private static int[][][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        arr=new int[21][21][21];
       while(true){

           String []input=br.readLine().split(" ");
           a=Integer.parseInt(input[0]);
           b=Integer.parseInt(input[1]);
           c=Integer.parseInt(input[2]);
           if(a==-1 && b==-1 && c==-1)
              break;
           sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a,b,c)).append("\n");


       }
        System.out.println(sb);

    }
    public static int w(int a,int b,int c) {
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if(a > 20 || b > 20|| c > 20) {
            return arr[20][20][20] = w(20, 20, 20);
        }

        if (arr[a][b][c] == 0) {
            if (a < b && b < c) {
                return arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            } else
                return arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);


        }
        return arr[a][b][c];
    }
}
