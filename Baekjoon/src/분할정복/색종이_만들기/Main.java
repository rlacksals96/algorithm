package 분할정복.색종이_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] input;
    private static int white=0;
    private static int blue=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        input=new int[n][n];
        for(int i=0;i<n;i++){
            String []str=br.readLine().split(" ");
            for(int j=0;j<n;j++)
                input[i][j]=Integer.parseInt(str[j]);
        }




        func(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void func(int px,int py,int length){



        int k=input[px][py];
        for(int i=px;i<px+length;i++){
            for(int j=py;j<py+length;j++){
                if(input[i][j]!=k){
                    func(px,py,length/2);
                    func(px+length/2,py,length/2);
                    func(px,py+length/2,length/2);
                    func(px+length/2,py+length/2,length/2);
                    return;
                }
            }
        }

        if(k==0)
            white++;
        else
            blue++;


    }
}
