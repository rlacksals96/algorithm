package 정렬;

import java.util.Scanner;

public class Main {

    private static int []arr;
    public static void bubbleSort(){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        arr=new int[N];

        for(int i=0;i<arr.length;i++) {
            arr[i] = sc.nextInt();
            if(!(Math.abs(arr[i])<=1000))
                throw new IllegalArgumentException();
        }
        bubbleSort();
        for (int j : arr) System.out.println(j);
    }
}
