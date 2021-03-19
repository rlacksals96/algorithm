package 우선순위_큐.최대_힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    private static PriorityQueue<Integer> x;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        x=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<T;i++){
            int k=Integer.parseInt(br.readLine());
            if(k==0){//print
                Integer tmp=x.peek();
                if(tmp==null)
                    System.out.println(0);
                else{
                    x.remove();
                    System.out.println(tmp);
                }
            }
            else{//input value
                x.add(k);
            }
        }

    }
}
