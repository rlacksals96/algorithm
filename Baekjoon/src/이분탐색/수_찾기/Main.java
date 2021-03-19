package 이분탐색.수_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int []a=new int[n];
        String[] str=br.readLine().split(" ");
        for(int i=0;i<a.length;i++)
            a[i]=Integer.parseInt(str[i]);
        Arrays.sort(a);

        int m=Integer.parseInt(br.readLine());
        int []b=new int[m];
        str=br.readLine().split(" ");
        for(int i=0;i<b.length;i++)
            b[i]=Integer.parseInt(str[i]);
        for(int i=0;i<b.length;i++){ // b[] 에 관하여..
            int left=0;
            int right=a.length-1;
            int mid=(left+right)/2;
            if(b[i]==a[left] || b[i]==a[right] || b[i]==a[mid]){
                System.out.println(1);
            }
            else if(b[i]<a[left] ||b[i]>a[right]){
                System.out.println(0);
            }else{
                while(true){
                    if(left+1==right){//없어서 못찾음
                        System.out.println(0);
                        break;
                    }else if(b[i]==a[mid] || b[i]==a[left] || b[i]==a[right]){//발견
                        System.out.println(1);
                        break;
                    }else if(b[i]<a[mid]){
                        right=mid;
                        mid=(left+right)/2;
                    }else{
                        left=mid;
                        mid=(left+right)/2;
                    }
                }
            }
        }

    }
}



//
//for(int i=0;i<m;i++){
//        int left=0;
//        int right=n-1;
//        int mid=(left+right)/2;
//        if(b[i]<a[0] || b[i]>a[n-1]){//out of boundary
//        System.out.println(0);
//
//        }
//        else{
//        for(int j=left;j<right;j++){
//        if(b[i]==a[mid] || b[i]==a[left] || b[i]==a[right]){//found it
//        System.out.println(1);
//        break;
//        }
//        else if(b[i]<a[mid]){
//        right=mid;
//        mid=(left+right)/2;
//        }else if(b[i]>a[mid]){
//        left=mid;
//        j=left;
//        mid=(left+right)/2;
//        }else{
//        System.out.println(0);
//        break;
//        }
//        }
//
//
//        }
//
//        }