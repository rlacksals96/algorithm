package dfs와bfs.단지번호붙이기_도전중;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

///////도전중........
public class Main {
    private static int N;
    private static ArrayList<Integer> []node;
    private static int [][]arr;
    private static boolean []visit;
    private static ArrayList<Integer> complex;
    private static int cnt;
    public static void main(String[] args) throws IOException {
        init();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i * N + j]) {
                    dfs(i * N + j);
                    complex.add(cnt);
                    cnt=0;
                }
            }
        }

        System.out.println(complex);
    }
    public static void dfs(int x){
        if(visit[x])
            return;
        visit[x]=true;
        cnt++;
        for(int i=0;i<node[x].size();i++){
            int y=node[x].get(i);
            dfs(y);
        }
    }
    public static void init() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        node=new ArrayList[N*N];
        visit=new boolean[N*N];
        complex=new ArrayList<>();
        cnt=0;
        Arrays.fill(visit,true);
        arr=new int[N][N];
        for(int i=0;i<node.length;i++)
            node[i]=new ArrayList<>();
        for(int i=0;i<N;i++){
            String []str=br.readLine().split("");
            for(int j=0;j<str.length;j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                if(arr[i][j]==1)
                    visit[i*N+j]=false;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i-1<0 && j-1<0)//(0,0) 부분
                    continue;
                else if(i+1>N && j+1>N)//(N,N)
                    continue;
                else if(i-1<0 && j+1>N)//(0,N)
                    continue;
                else if(i+1>N && j-1<0)//(N,0)
                    continue;


            }
        }
    }
    public static void connect(int i,int j){
//        if(arr[i+1][j]==1){
//            node[i*N+j].add((i+1)*N+j);
//        }
//        if(arr[i-1][j]==1){
//            node[i*N+j].add((i-1)*N+j);
//        }
//        if(arr[i][j+1]==1){
//            node[i*N+j].add((i)*N+(j+1));
//        }
//        if(arr[i][j-1]==1){
//            node[i*N+j].add((i)*N+(j-1));
//        }
        node[i].add(j);
    }
}