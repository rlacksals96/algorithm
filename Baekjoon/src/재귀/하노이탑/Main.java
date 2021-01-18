package 재귀.하노이탑;

import java.util.Scanner;

public class Main {
    private int cnt;
    private int size=10;
    private int []from;
    private int []to;
//    private int []brick;
    public Main(){
        cnt=0;
        from=new int[size];
        to=new int[size];
//        brick=new int[size];
    }
    public void updateSize(){
        int []tmp1=new int[size*2];
        int []tmp2=new int[size*2];
        for(int i=0;i<from.length;i++){
            tmp1[i]=from[i];
            tmp2[i]=to[i];
        }
        size*=2;
        from=tmp1;
        to=tmp2;
    }
    public void printResult(){
        System.out.println(cnt);
        for(int i=0;i<cnt;i++){
//            System.out.println(brick[i]+" "+from[i]+" "+to[i]);
            System.out.println(from[i]+" "+to[i]);

        }
    }
    public void hanoi(int n,int start,int end,int via){
        if(n==1)
            move(1,start,end);
        else{
            hanoi(n-1,start,via,end);
            move(n,start,end);
            hanoi(n-1,via,end,start);
        }
    }
    public void move(int n,int start,int end){
        //...
        from[cnt]=start;
        to[cnt]=end;
//        brick[cnt]=n;
        cnt++;
        if(size-cnt<2)
            updateSize();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        Main m=new Main();
        m.hanoi(N,1,3,2);

        m.printResult();
    }
}
