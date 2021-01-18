package 기본수학2.네번쨰점;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int []x=new int[4];
        int []y=new int[4];
        for(int i=0;i<3;i++){
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();

            if(!(1<=x[i]&&x[i]<=1000))
                throw new IllegalArgumentException();
            if(!(1<=y[i]&&y[i]<=1000))
                throw new IllegalArgumentException();
        }
        if(x[0]==x[1]) {
            x[3] = x[2];
            if(y[2]==y[0])
                y[3]=y[1];
            else
                y[3]=y[0];
        }
        else if(x[0]==x[2]){
            x[3] = x[1];
            if(y[1]==y[0])
                y[3]=y[2];
            else
                y[3]=y[0];
        }
        else{//x[0]==x[3]
            x[3]=x[0];
            if(y[0]==y[1])
                y[3]=y[2];
            else
                y[3]=y[1];

        }
        System.out.println(x[3]+" "+y[3]);
    }
}
