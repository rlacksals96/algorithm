package 기본수학2.직사각형에서탈출;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int w,h,x,y;
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        y=sc.nextInt();
        w=sc.nextInt();
        h=sc.nextInt();

        if(!((1<=w && w<=1000)&&(1<=h&&h<=1000)))
            throw new IllegalArgumentException();
        if(!(1<=x&&x<=w-1))
            throw new IllegalArgumentException();
        if(!(1<=y&&y<=h-1))
            throw new IllegalArgumentException();

        System.out.println(calculate(x,y,w,h));
    }
    public static int calculate(int x,int y,int w,int h){
        int shortestX=0;
        int shortestY=0;
        shortestX = Math.min(Math.abs(w-x), x);
        shortestY=Math.min(Math.abs(h-y),y);
        return Math.min(shortestX,shortestY);
    }
}
