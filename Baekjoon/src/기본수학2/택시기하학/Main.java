package 기본수학2.택시기하학;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int R=sc.nextInt();
        if(!(R<=10000))
            throw new IllegalArgumentException();
        double ulid=Math.pow(R,2)*Math.PI;
        double taxi=2*Math.pow(R,2);

        System.out.printf("%.6f\n",ulid);
        System.out.printf("%.6f",taxi);
    }
}
