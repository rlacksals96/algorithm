package 탐색.bfs;

import java.io.*;
import java.util.*;

public class Main {

    private static int V,E,S;
    private static int x,y;
    static ArrayList<Integer> [] graph;
    static ArrayList<Integer> bfs;

    static boolean [] visit;
    static Queue<Integer> Q;

    static BufferedReader br;
    static BufferedWriter bw;

    static StringTokenizer st;

    private static void bfsSol(){
        bfs=new ArrayList<Integer>();
        visit=new boolean[E+1];
        Q=new LinkedList<Integer>();

        Q.add(S);
        visit[S]=true;

        while(!Q.isEmpty()){
            //pop기능임
            int q=Q.poll();
            // 최종적으로 bfs의 결과는 bfs 안에 저장됨.
            bfs.add(q);
            //graph[i]는 arraylist로써 안에 자신과 연결된 노드들의 정보가 있다. if()에 의해 중복은 필터링 됨.
            for(int i:graph[q]){
                if(!visit[i]){
                    Q.add(i);
                    visit[i]=true;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        bw=new BufferedWriter(new OutputStreamWriter(System.out));

        st=new StringTokenizer(br.readLine());

        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());

        //graph배열 동적할당 후, graph배열의 원소(ArrayList[i])마다 연결된 노드 번호 기입(x,y)
        graph=new ArrayList[E+1];
        for(int i=1;i<=E;i++)
            graph[i]=new ArrayList<Integer>();

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());

            //방향이 없어서 양쪽으로 연결
            graph[x].add(y);
            graph[y].add(x);
        }

        for(int i=1;i<=E;i++){
            Collections.sort(graph[i]);
        }
        bfsSol();
        for (Integer bf : bfs) System.out.print(bf + " ");

    }
}
