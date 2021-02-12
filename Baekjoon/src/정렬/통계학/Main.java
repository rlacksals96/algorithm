package 정렬.통계학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static double calculateAverage(int[] arr){

        int sum=0;
        for(int i:arr)
            sum+=i;
        return (double)sum/arr.length;
    }
    public static int calculateMedian(int[] arr){

        return arr[arr.length/2];
    }
    public static int calculateRange(int[] arr){

        return arr[arr.length-1]-arr[0];

    }
    public static int calculateMode(int[] arr){

        int []cnt=new int[8000+1];
        Arrays.fill(cnt,0);
        for(int i=0;i<arr.length;i++){//-:0~4000, +:4000~8000
            cnt[arr[i]+4000]++;
        }
        int max=cnt[0];
        for(int k:cnt){
            if(max<k)
                max=k;
        }
        ArrayList<Integer> maxIdx=new ArrayList<Integer>();
        for(int i=0;i<cnt.length;i++){
            if(max==cnt[i])
                maxIdx.add(i);
        }
        if(maxIdx.size()==1)
            return maxIdx.get(0)-4000;
        else
            return maxIdx.get(1)-4000;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());


        int N=Integer.parseInt(st.nextToken());
        int []arr;
        arr=new int[N];
        long t1=System.currentTimeMillis();
        for(int i=0;i<arr.length;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        double avg=calculateAverage(arr);
        int median=calculateMedian(arr);
        int range=calculateRange(arr);
        int mode=calculateMode(arr);

        System.out.println(Math.round(avg));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);

    }
}
