package 유니온_파인드.여행_가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int []cities;
    private static int []plans;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        cities=new int[n+1];
        for(int i=1;i<= n;i++)
            cities[i]=i;

        for(int i=1;i<=n;i++){
            String []str=br.readLine().split(" ");

            for(int j=0;j<str.length;j++){
                if(Integer.parseInt(str[j])==1)
                    unionCity(i,j+1);

            }

        }


        //노드 입력 및 노드 간 연결 완료

        String[] str=br.readLine().split(" ");
        plans=new int[str.length];
        for(int i=0;i<str.length;i++)
            plans[i]=Integer.parseInt(str[i]);
        //계획 저장 완료

        int parent=cities[plans[0]];//마지막 연결구역임.. 값 넣었을때 모두 같은 부모 나오면 가능한 거임.
        for(int i=1;i<plans.length;i++){
            if(cities[plans[i]]!=parent) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");


    }

    public static void unionCity(int a,int b){
        a=getParent(a);
        b=getParent(b);
        if(a>b)
            cities[a]=b;
        else
            cities[b]=a;
    }
    public static int getParent(int a){
        if(cities[a]==a)
            return a;
        else
            return cities[a]=getParent(cities[a]);
    }
}
