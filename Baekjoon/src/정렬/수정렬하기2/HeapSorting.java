package 정렬.수정렬하기2;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSorting{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        int N=sc.nextInt();
//
//        int[] arr=new int[N];
//        for(int i=0;i<arr.length;i++){
//            arr[i]=sc.nextInt();
//        }
        int []arr={9,6,8,1,3,7,10,2,4,5};

        System.out.println("heap sort");
        sortByHeap(arr);

        System.out.println("bubble sort");
        sortByBubble(arr);

        System.out.println("insertion sort");
        sortByInsertion(arr);
    }

    /*
    * 거의 정렬이 된 상태라면 퀵, 힙 소트보다 정렬 속도가 더 빠를 수 있다.
    * */
    public static void sortByInsertion(int[] arr){
        int[] arr3;
        arr3=arr.clone();

        for(int i=0;i<arr3.length-1;i++){
            int j=i;
            while(arr3[j]>arr3[j+1]) {
                swap(arr3, j, j+1);
                j--;
                if(j<0)
                    break;
            }
        }
        System.out.println(Arrays.toString(arr3));
    }
    public static void sortByBubble(int[] arr){

        int [] arr2;
        arr2=arr.clone();
        for(int i=0;i<arr2.length;i++){
            for(int j=i;j<arr2.length;j++){
                if(arr2[i]>arr2[j])
                    swap(arr2,i,j);
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
    public static void sortByHeap(int[]arr){
        int[] arr1=new int[arr.length];
        arr1=arr.clone();

        for(int i=1;i<arr1.length;i++){
            int c=i;
            do{
                int root=(c-1)/2;
                if(arr1[root]<arr1[c])
                    swap(arr1,root,c);
                c=root;
            }while(c!=0);
        }

        for(int i=arr1.length-1;i>=0;i--){
            swap(arr1,0,i);
            int c;
            int root=0;
            do{
                c=2*root+1;
                if(c<i-1 && arr1[c]<arr1[c+1])
                    c++;
                if(c<i && arr1[c]>arr1[root])
                    swap(arr1,c,root);
                root=c;
            }while(c<i);
        }
        System.out.println(Arrays.toString(arr1));

    }

    public static void swap(int[] arr,int a,int b){
        int tmp;
        tmp=arr[a];
        arr[a]=arr[b];
        arr[b]=tmp;

    }
}