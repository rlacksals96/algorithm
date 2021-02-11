package 기본수학2.터렛;

import java.util.Scanner;

public class Main{
    public static int[] calculate(int []x1,int []y1,int []r1,int []x2,int []y2,int []r2){
        int []result=new int[x1.length];
        for(int i=0;i<x1.length;i++){
            double distance=Math.sqrt(Math.pow(x1[i]-x2[i],2)+Math.pow(y1[i]-y2[i],2));

            if(Math.abs(r1[i]-r2[i])<distance && distance<r1[i]+r2[i])//contact 2
                result[i]=2;
            else if(r1[i]+r2[i]==distance)//외접 1개
                result[i]=1;
            else if(Math.abs(r1[i]-r2[i])==distance && distance !=0)//내접 1
                result[i]=1;
            else if(distance<Math.abs(r1[i]-r2[i]))//1개 원포함 && 만나진 않음
                result[i]=0;
            else if(distance>r1[i]+r2[i])//서로 떨어져서 안만남
                result[i]=0;
            else if(distance==0 && r1[i]==r2[i])
                result[i]=-1;


        }

        return result;

    }
   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int []x1=new int[T];
        int []y1=new int[T];
        int []r1=new int[T];
        int []x2=new int[T];
        int []y2=new int[T];
        int []r2=new int[T];
        int []result;

        for(int i=0;i<T;i++){
            x1[i]=sc.nextInt();
            y1[i]=sc.nextInt();
            r1[i]=sc.nextInt();
            x2[i]=sc.nextInt();
            y2[i]=sc.nextInt();
            r2[i]=sc.nextInt();
            if(!((-10000<=x1[i]&&x1[i]<=10000) ||
                    (-10000<=y1[i]&&y1[i]<=10000) ||
                    (-10000<=r1[i]&&r1[i]<=10000) ||
                    (-10000<=x2[i]&&x2[i]<=10000) ||
                    (-10000<=y2[i]&&y2[i]<=10000) ||
                    (-10000<=r2[i]&&r2[i]<=10000)
            ))
                throw new IllegalArgumentException();
        }

        result=calculate(x1,y1,r1,x2,y2,r2);

        for (int j : result) System.out.println(j);
    }
}