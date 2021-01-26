package 정렬.수정렬하기2;

import java.util.Random;
import java.util.Scanner;

//one pivot quickSort
public class Main {
    public void swap(int []arr, int i, int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public int getMedian(int[] arr,int p,int r){
        int first=arr[p];
        int last=arr[r];
        int mid=arr[(p+r)/2];

        return (int) Math.floor((first+mid+last)/3);
    }
    /*
    * pivot의 경우의 수
    * 1. 배열 첫번째 또는 맨 마지막 번째
    * 2. median of three: first, mid, last 값의 중간값을 선택. 최악의 경우 시간 복잡도가 달라지지 않음
    * 3. randomized quicksort: 최악의 입력이라는 개념이 사라짐(어차피 랜덤이라서)
    * 다만 운이 안좋은 경우(항상 최소값만 선택하는 경우) 시간복잡도가 최악이다.
    * */
    public int partition(int[] arr,int p,int r){
//        int x=arr[r];
        int x=getMedian(arr,p,r);
//        Random rand=new Random();
//        int x=rand.nextInt(arr.length);
        int i=p-1;
        for(int j=p;j<r;j++){
            if(arr[j]<=x){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,r);
        return i+1;
    }
    /*
    * i: pivot보다 작은 값들 중 마지막 값의 위치
    * j: 지금 검사하려는 위치의 값
    * ~ j-1: 이미 검사해서 pivot과 비교해서 대소비교 및 자리 교환이 끝난 상태
    * */
    public void quickSort(int[] arr,int p,int r){
        if(p<r){
            int q=partition(arr,p,r);
            quickSort(arr,p,q-1);
            quickSort(arr,q+1,r);
        }

    }

    public void run(int[] arr){
        quickSort(arr,0,arr.length-1);

        for(int i:arr)
            System.out.println(i);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        if(!(1<=N && N<=1000000))
            throw new IllegalArgumentException();

        int []arr=new int[N];

        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
            if(!(Math.abs(arr[i])<=1000000))
                throw new IllegalArgumentException();
        }
        Main m=new Main();
        m.run(arr);


    }
}
