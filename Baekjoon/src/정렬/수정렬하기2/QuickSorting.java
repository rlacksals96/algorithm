package 정렬.수정렬하기2;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSorting {
    private static int[] result;

    public static void merge(int[] arr,int m,int mid,int n){
        int i=m;
        int j=mid+1;
        int k=m;

        while(i<=mid && j<=n){
            if(arr[i]<=arr[j]){
                result[k]=arr[i];
                i++;
            }else{
                result[k]=arr[j];
                j++;
            }
            k++;
        }
        if(i>mid){
            for(int t=j;t<=n;t++) {
                result[k] = arr[t];
                k++;
            }
        }else{
            for(int t=i;t<=mid;t++){
                result[k]=arr[t];
                k++;
            }
        }

        if (n + 1 - m >= 0) System.arraycopy(result, m, arr, m, n + 1 - m);
    }
    public static void quickSort(int[] arr,int m,int n){
        if(m<n){
            int mid=(m+n)/2;
            quickSort(arr,m,mid);
            quickSort(arr,mid+1,n);
            merge(arr,m,mid,n);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int []arr=new int[N];
        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();

        result=new int[N];
        quickSort(arr,0,arr.length-1);

        for(int i:arr)
            System.out.println(i);

    }
}
