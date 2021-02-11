package 탐색.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static ArrayList<Integer>[]a;
    private static boolean []c=new boolean[8];

    public static void dfs(int x){
        if(c[x]) return;
        //else
        c[x]=true;
        System.out.print(x+" ");
        for(int i=0;i< a[x].size() ;i++){
            int y=a[x].get(i);
            dfs(y);
        }

    }

    public static void main(String[] args) {
        Arrays.fill(c, false);

        a=new ArrayList[8];
        for(int i=0;i<a.length;i++)
            a[i]=new ArrayList<>();

        a[1].add(2);
        a[2].add(1);

        a[2].add(4);
        a[4].add(2);

        a[2].add(5);
        a[5].add(2);

        a[3].add(6);
        a[6].add(3);

        a[3].add(7);
        a[7].add(3);

        a[2].add(3);
        a[3].add(2);

        dfs(1);
    }
}
