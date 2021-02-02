package 정렬.수정렬하기2;

import java.util.Arrays;

public class HeapSorting {

    public static void main(String[] args) {
        int[] heap={1,2,3,4,5,6,7,8,9};

        //먼저 전체 전체 트리 구조를 heap 구조로 바꾸기
        for(int i=1;i<heap.length;i++){
            int c=i;
            do{
                int root=(c-1)/2;
                if(heap[root]<heap[c]){
                    int tmp=heap[root];
                    heap[root]=heap[c];
                    heap[c]=tmp;
                }
                c=root;
            }while(c!=0);
        }
        // 크기를 줄여가면서 반복적으로 힙 구성
        for(int i=heap.length-1;i>=0;i--){
            int tmp=heap[0];
            heap[0]=heap[i];
            heap[i]=tmp;
            //가장 큰 값을 맨 밑으로 보냄
            int root=0;
            int c=1;
            do{
                c=2*root+1;
                if(heap[c]<heap[c+1] && c<i-1){
                    c++;
                }
                //로투보다 자식이 크면 교환
                if(heap[root]<heap[c] && c<i){
                    tmp=heap[root];
                    heap[root]=heap[c];
                    heap[c]=tmp;
                }
                root=c;
            }while(c<i);
        }
        System.out.println(Arrays.toString(heap));
    }

}
