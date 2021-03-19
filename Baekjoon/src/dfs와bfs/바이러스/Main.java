package dfs와bfs.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int computer;
    private static int linker;
    private static boolean []visit;
    private static int cnt;
    private static ArrayList<Integer> []node;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        computer=Integer.parseInt(br.readLine());
        linker=Integer.parseInt(br.readLine());
        node=new ArrayList[computer+1];
        visit=new boolean[computer+1];
        cnt=0;

        //init array
        Arrays.fill(visit,false);
        for(int i=0;i<node.length;i++)
            node[i]=new ArrayList<>();
        for(int i=0;i<linker;i++){
            String[] tmp=br.readLine().split(" ");
            node[Integer.parseInt(tmp[0])].add(Integer.parseInt(tmp[1]));
            node[Integer.parseInt(tmp[1])].add(Integer.parseInt(tmp[0]));
        }

        //dfs version
        dfs(1);
        System.out.println(cnt-1);

        //bfs version
        Arrays.fill(visit,false);
        cnt=0;
        bfs(1);
        System.out.println(cnt-1);
    }
    public static void bfs(int start){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        visit[start]=true;

        while(!queue.isEmpty()){
            int x=queue.poll();
            cnt++;
            for(int i=0;i<node[x].size();i++){
                int y=node[x].get(i);
                if(!visit[y]){
                    visit[y]=true;
                    queue.add(y);
                }
            }
        }
    }
    public static void dfs(int start){
        if(visit[start])
            return;
        cnt++;
        visit[start]=true;
        for(int i=0;i<node[start].size();i++){
            int y=node[start].get(i);
            dfs(y);
        }
    }

}
