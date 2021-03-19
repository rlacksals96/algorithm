package dfs와bfs.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Main {

    private static ArrayList<Integer>[]node;
    private static boolean []isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N=Integer.parseInt(str[0]);
        int M=Integer.parseInt(str[1]);
        int V=Integer.parseInt(str[2]);
        node=new ArrayList[N+1];
        isVisited=new boolean[N+1];
        Arrays.fill(isVisited,false);

        for(int i=0;i<N;i++)
            node[i]=new ArrayList<>();
        for(int i=0;i<M;i++){
            String []tmp=br.readLine().split(" ");
            node[Integer.parseInt(tmp[0])].add(Integer.parseInt(tmp[1]));
        }
        dfs(V);
//        Arrays.fill(isVisited,false);
//        bfs(V);

    }
    public static void bfs(int x){

    }
    public static void dfs(int x){
        if(isVisited[x])
            return;
        isVisited[x]=true;
        System.out.println(x+" ");
        for(int i=0;i<node[x].size();i++){
            int y=node[x].get(i);
            dfs(y);
        }
    }
}
