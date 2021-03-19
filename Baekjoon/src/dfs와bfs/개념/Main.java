package dfs와bfs.개념;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int num=7;
    private static boolean []isUsed=new boolean[8];
    private static ArrayList<Integer>[] a=new ArrayList[8];

    public static void main(String[] args) {
        for(int i=0;i<8;i++)
            a[i]=new ArrayList();
       a[1].add(2);
       a[2].add(1);

       a[1].add(3);
       a[3].add(1);

       a[2].add(3);
       a[3].add(2);

       a[2].add(4);
       a[4].add(2);

       a[2].add(5);
       a[5].add(2);

       a[4].add(5);
       a[5].add(4);

       a[3].add(6);
       a[6].add(3);

       a[3].add(7);
       a[7].add(3);

       a[6].add(7);
       a[7].add(6);

       bfs(1);

    }
    public static void bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        isUsed[start]=true;
        while(!q.isEmpty()){
            int x=q.poll();
            System.out.print(x+" ");
            for(int i=0;i<a[x].size();i++){
                int y=a[x].get(i);
                if(!isUsed[y]){
                    q.add(y);
                    isUsed[y]=true;
                }
            }
        }

    }
}
