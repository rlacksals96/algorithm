package 재귀.로또;

// #6603번

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    private List[] result;
    private int cnt;
    private int size;
    public Main() {
        size=10;
        result=new List[size];
        cnt=0;
    }

    public void mkCombi(List<int[]> combinations,int []data,int start,int end,int index){
        if(index==data.length){
            int[] combination=data.clone();
            combinations.add(combination);
        }
        else if(start<=end){
            data[index]=start;
            mkCombi(combinations,data,start+1,end,index+1);
            mkCombi(combinations,data,start+1,end,index);
        }
    }
    public List<int[]> generate(int n,int r,int []set){
        List<int[]> combinations=new ArrayList<>();

        mkCombi(combinations,set,0,n-1,0);
        return combinations;
    }
    public void printResult(){
        for(int i=0;i< result.length;i++)
            System.out.println(result[i].toString());
    }
    public void updateSize(){
        List []tmpResult=new List[this.size*2];
        for(int i=0;i<this.cnt;i++){
            tmpResult[i]=result[i];
        }
        this.size*=2;
        result=tmpResult;
    }
    public void run() {
        try {
            while (true) {
                int T = sc.nextInt();
                if (T == 0) {
                    printResult();
                    break;
                } else {
                    int[] set = new int[6];
                    for (int i : set)
                        set[i] = sc.nextInt();
                    result[cnt] = generate(T, 6, set);
                    cnt++;
                }
                if (size - cnt < 2)
                    updateSize();
            }
        }catch(NullPointerException ne){
            ;
        }


    }

    public static void main(String[] args) {
         Main m=new Main();
         m.run();
    }
}
