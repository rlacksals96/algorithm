package 정렬.좌표정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());

        Cordinate []cord=new Cordinate[N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            cord[i]=new Cordinate(x,y);


        }
        Arrays.sort(cord);
        for(Cordinate c:cord)
            System.out.println(c.getX()+" "+c.getY());



    }
}
class Cordinate implements Comparable{
    private int x;
    private int y;

    public Cordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }



    public int getY() {
        return y;
    }


    @Override
    public int compareTo(Object o) {
        Cordinate cor=(Cordinate)o;
        if(cor.x>x)
            return -1;
        else if(cor.x<x)
            return 1;
        else {
            return Integer.compare(y, cor.y);
        }

    }
}