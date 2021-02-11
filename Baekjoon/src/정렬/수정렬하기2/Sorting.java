package 정렬.수정렬하기2;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    private static int[] result;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        int N=sc.nextInt();
//
//        int[] arr=new int[N];
//        for(int i=0;i<arr.length;i++){
//            arr[i]=sc.nextInt();
//        }
        int []arr={5,4,3,2,1};

        System.out.println("quick sort");
        int []arr1=arr.clone();

        sortByQuick(arr1,0,arr.length-1);
        System.out.println(Arrays.toString(arr1));

        System.out.println("heap sort");
        int[] arr2=arr.clone();
        sortByHeap(arr2);

        System.out.println("bubble sort");
        int[] arr3=arr.clone();
        sortByBubble(arr3);

        System.out.println("insertion sort");
        int[] arr4=arr.clone();
        sortByInsertion(arr4);

        System.out.println("merge sort");
        int[] arr5=arr.clone();
        result=new int[arr.length];
        sortbyMerge(arr5,0,arr5.length-1);
        System.out.println(Arrays.toString(arr5));


    }
    public static void sortByQuick(int[] arr,int start,int end){
        if(start>=end)//start & end에서 각각 원소가 1개씩 밖에 없어서 바꿀 필요가 없는 경우이다.
            return;
        int pivot=start;
        int i=start+1;
        int j=end;

        while(i<=j){
            while(i<=end && arr[i]<=arr[pivot])//pivot보다 작은 수들은 pivot이 있어야 하는 위치보다 왼쪽에 있으니
                i++;
            while(j>start && arr[j]>=arr[pivot])//pivot보다 큰수들은 pivot보다 오른쪽에만 있으니
                j--;

            if(i>j)//i,j가 교차하는 경우 pivot과 j를 교체(i를 교체하면 array 범위 넘어감... 이유는 아직 잘 모르겠음)
                swap(arr,pivot,j);
            else
                //i,j가 교차하지 않은 경우.. 그냥 i가 pivot보다 큰데 pivot보다 왼쪽에 있고,
                // j가 pivot보다 작은데 pivot보다 오른쪽에 있어서
                // 둘이 교환해주는 것이다.
                swap(arr,i,j);
        }
        sortByQuick(arr,start,j-1);
        sortByQuick(arr,j+1,end);
    }

    /*
    * 거의 정렬이 된 상태라면 퀵, 힙 소트보다 정렬 속도가 더 빠를 수 있다.
    * */
    public static void sortByInsertion(int[] arr){

        for(int i=0;i<arr.length-1;i++){
            int j=i;
            while(arr[j]>arr[j+1]) {
                swap(arr, j, j+1);
                j--;
                if(j<0)
                    break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void sortByBubble(int[] arr){

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i]>arr[j])
                    swap(arr,i,j);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void sortByHeap(int[]arr){

        for(int i=1;i<arr.length;i++){
            // c는 자식 노드로, 위에서 부터 차례대로 루트와 자신의 위치를 바꿔나간다. 이전 노드까지는 적절한 위치에 있으므로 재정렬은 필요없지.
            int c=i;
            do{
                int root=(c-1)/2;
                if(arr[c]>arr[root])
                    swap(arr,c,root);
                c=root;
            }while(c!=0);
        }

        //루트(가장 큰수 존재)와 맨 마지막 노드와 자리를 바꾸고, 맨 마지막(제일 큰 수)를 제외한 나머지끼리 heapify를 다시 시행.
        for(int i=arr.length-1;i>=0;i--){
            int c;
            swap(arr,i,0);
            int root=0;
            do{
                c=2*root+1;
                //왼쪽보다 오른쪽이 크면 c가 오른쪽 노드를 가리키게 한다.
                if(c<i-1 && arr[c]<arr[c+1])
                    c++;
                //맨 위에서부터 i(맨 밑에서 두번째부터 시작해서 맨 처음까지)로 내려가면서 변경.
                if(c<i && arr[c]>arr[root]){
                    swap(arr,c,root);
                }
                root=c;
            }while(c<i);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void sortbyMerge(int[] arr, int m, int n){
        if(m<n){
            int mid=(m+n)/2;
            sortbyMerge(arr,m,mid);
            sortbyMerge(arr,mid+1,n);
            merge(arr,m,mid,n);
        }
    }
    public static void merge(int[] arr,int m,int mid,int n){//m: start, mid: 배열1,2 중간지대, n: 끝부분
        int i=m;
        int j=mid+1;
        int k=m;

        //작은 순서대로 배열에 삽입
        while(i<=mid && j<=n) {
            if (arr[i] <= arr[j]) {
                result[k] = arr[i];
                i++;
            } else {
                result[k] = arr[j];
                j++;
            }
            k++;
        }
        //input rest
        if(i>mid){
            for(int t=j;t<=n;t++){
                result[k]=arr[t];
                k++;
            }
        }else{
            for(int t=i;t<=mid;t++){
                result[k]=arr[t];
                k++;
            }
        }
        for(int t=m;t<=n;t++)
            arr[t]=result[t];


    }
    public static void swap(int[] arr,int a,int b){
        int tmp;
        tmp=arr[a];
        arr[a]=arr[b];
        arr[b]=tmp;

    }
}