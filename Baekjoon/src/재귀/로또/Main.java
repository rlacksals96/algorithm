package 재귀.로또;

// #6603번

import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    public void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr){
        if(r == 0){//r개의 원소를 모두 선택후 마지막 재귀 함수에 진입한 상태
            for(int i=0; i<index; i++) System.out.print(arr[combArr[i]] + " ");
            System.out.println();
        }else if(target == n) return;//부분탐색트리로 보면 맨 아래까지 왔는데 원하는 부분집합을 찾지 못한 경우
        else{
            combArr[index] = target;
            doCombination(combArr, n, r-1, index+1, target+1, arr);
            /*
            * 특정 원소를 택한후, 선택한 원소의 위치를 저장하는 combArr에 값을 저장후, index++, 검색 target도 다음 위치로
            * 넘어가기 위해 +1
            * */
            doCombination(combArr, n, r, index, target+1, arr);
            /*
            * 특정 원소를 택히자 않았으므로, r개 그대로 유지, combArr에 저장한게 없으니 index도 변함 없고, 다음 타켓 선택위해
            * target+1
            * */
        }
    }

    public void run() {
        try {
            while (true) {
                int T = sc.nextInt();
                if (T == 0) {
                    break;
                } else {
                    int[] data = new int[T];
                    int[] combArr=new int[6];
                    for(int i=0;i<data.length;i++)
                        data[i]=sc.nextInt();
                    doCombination(combArr,data.length,6,0,0,data);
                    System.out.println();
                }
            }
        }catch(NullPointerException ne){
            ne.printStackTrace();
        }

    }

    public static void main(String[] args) {
         Main m=new Main();
         m.run();
    }
}
