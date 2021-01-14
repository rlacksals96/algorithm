package 기본수학2.직각삼각형;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       Rectangle r=new Rectangle();
       r.run();
    }
}

class Rectangle{
    private int []a;
    private int []b;
    private int []c;
    private boolean []isRect;
    private int size;
    private int cnt;

    public Rectangle() {
        size=10;
        cnt=0;
        a=new int[size];
        b=new int[size];
        c=new int[size];
        isRect=new boolean[size];
    }
    public void updateSize(){
        size*=2;
        int []tmpA=new int[size];
        int []tmpB=new int[size];
        int []tmpC=new int[size];
        boolean []tmpIsRect=new boolean[size];

        for(int i=0;i<cnt;i++){
            tmpA[i]=a[i];
            tmpB[i]=b[i];
            tmpC[i]=c[i];
            tmpIsRect[i]=isRect[i];
        }
        a=tmpA;
        b=tmpB;
        c=tmpC;
        isRect=tmpIsRect;
    }
    public boolean calculate(int a,int b,int c){
        int max;
        int k,l;
        if(a>=b && a>=c){
            max=a;
            k=b;
            l=c;
        }else if(b>=a && b>=c){
            max=b;
            k=a;
            l=c;
        }else{
            max=c;
            k=a;
            l=b;
        }
        return Math.pow(max, 2) == (Math.pow(k, 2) + Math.pow(l, 2));
    }
    public void run(){
        Scanner sc=new Scanner(System.in);
        while(true){
            a[cnt]=sc.nextInt();
            b[cnt]=sc.nextInt();
            c[cnt]=sc.nextInt();
            if(!(a[cnt]<10000 || b[cnt]<10000 || c[cnt]<10000))
                throw new IllegalArgumentException();
            if(a[cnt]==0 && b[cnt]==0 && c[cnt]==0)
                break;
            else{
                isRect[cnt]=calculate(a[cnt],b[cnt],c[cnt]);
                cnt++;
            }

            if(size-cnt<2)
                updateSize();
        }
        for (int i=0;i<cnt;i++) {
            if (isRect[i])
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}
