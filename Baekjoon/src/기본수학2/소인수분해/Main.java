package 기본수학2.소인수분해;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N;
        int divider=2;
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        if(N<1 || N>10000000)
            throw new IllegalArgumentException();
        if(N==1)
            return;
        while(N>1){
            while(N%divider==0){
                N=N/divider;
                System.out.println(divider);
            }
            divider++;
        }
    }
}
