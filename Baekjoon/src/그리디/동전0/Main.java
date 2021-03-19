package 그리디.동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int k=Integer.parseInt(str[1]);
        int []coin=new int[n];
        for(int i=0;i<coin.length;i++){
            coin[i]=Integer.parseInt(br.readLine());
        }
        int idx=n-1;
        while(coin[idx]>k)
            idx--;

        int cnt=0;
        while(k>0){
            cnt+=k/coin[idx];
            k%=coin[idx];
            idx--;
        }
        System.out.println(cnt);



    }
}
