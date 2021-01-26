package 정렬.수정렬하기2;

import java.util.Arrays;
import java.util.Scanner;

//dual pivot quick sort by using built-in method
public class QuickSorting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int []arr=new int[N];
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();

        Arrays.sort(arr);
        for(int i:arr)
            System.out.println(i);
    }
}
