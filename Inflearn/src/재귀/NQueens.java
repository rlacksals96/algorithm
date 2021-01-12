package 재귀;


import java.util.Arrays;
import java.util.Scanner;

public class NQueens {


    private int[]cols;
    private int N;
    NQueens(int N){
        cols=new int[N+1];
        Arrays.fill(cols,0);
        this.N=N;
    }

    boolean queens(int level){
        if(!promising(level))
            return false;
        else if(level==N) {
            for(int i=1;i<=N;i++)
                System.out.print("("+i+","+cols[i]+") ");
            System.out.println();
            return true;
        }

        for(int i=1;i<=N;i++){
            cols[level+1]=i;
            if(queens(level+1))
                return true;
        }
        return false;

    }
    boolean promising(int level){
        for(int i=1;i<level;i++){

            if(cols[i]==cols[level])//x좌표가 일치한다는 의미
                return false;
            else if( level-i == Math.abs(cols[i] - cols[level]))//같은 대각 선상에 있다는 의미..대각선이면 가로,세로 길이가 같다는 것을 활용한 것임.
                return false;

        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        NQueens nq=new NQueens(N);
        nq.queens(0);


    }
}

/*
* backtracking: 실행 결과 불가능하다는 결과가 나오면 최근의 결정을 번복하고, 새로운 경우를 택하는 경우
* 상태공간 tree: 찾는 해를 포함하는 트리
* -> 해가 존재한다면 그것은 반드시 이 트리의 어떤 한 노드에 해당함. 따라서 이 트리를 체계적으로 탐색하면 해를 구할수 있다
* + 모든 노드를 탐색해야하는 것은 아니다
* 예) 1,1 가 성립된다고 할때, 2,1은 같은 y축에 존재하기 떄문에 그 밑에 있는 노드들은 탐색해볼 필요도 없다.
* (1,1)과 (2,1)의 관계에서 (2,1)은 'non-promising(=infeasible)[실행불가능한]' 한 상태이다.
* */