package dfs와bfs.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static ArrayList<Integer>[] node;
    private static boolean []isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N=Integer.parseInt(str[0]);
        int M=Integer.parseInt(str[1]);
        int V=Integer.parseInt(str[2]);
        node= new ArrayList[N+1];
        isVisited=new boolean[1+N];
        Arrays.fill(isVisited,false);

        for(int i=0;i<N+1;i++)
            node[i]=new ArrayList<>();
        for(int i=0;i<M;i++){
            String []tmp=br.readLine().split(" ");
            node[Integer.parseInt(tmp[0])].add(Integer.parseInt(tmp[1]));
            node[Integer.parseInt(tmp[1])].add(Integer.parseInt(tmp[0]));

            Collections.sort(node[Integer.parseInt(tmp[0])]);
            Collections.sort(node[Integer.parseInt(tmp[1])]);

        }
        dfs(V);
        System.out.println();
        Arrays.fill(isVisited,false);
        bfs(V);

    }
    public static void bfs(int start){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        isVisited[start]=true;
        while(!queue.isEmpty()){
            int x=queue.poll();
            System.out.print(x+" ");
            for(int i=0;i<node[x].size();i++){
                int y=node[x].get(i);
                if(!isVisited[y]){
                    queue.add(y);
                    isVisited[y]=true;
                }

            }
        }

    }
    public static void dfs(int x){
        if(isVisited[x])
            return;
        isVisited[x]=true;
        System.out.print(x+" ");
        for(int i=0;i<node[x].size();i++){
            int y=(int)node[x].get(i);
            dfs(y);
        }
    }
}
