package 정렬.좌표정렬하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        Cordinate [] cord=new Cordinate[N];
        for(int i=0;i<cord.length;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
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
        Cordinate cord=(Cordinate)o;
        if(cord.getY()>y)
            return -1;
        else if(cord.getY()<y)
            return 1;
        else{
            return Integer.compare(x,cord.getX());
        }
    }
}
