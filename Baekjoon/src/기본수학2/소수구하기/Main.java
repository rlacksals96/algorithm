package 기본수학2.소수구하기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N, M;
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        if (!(1 <= M && M <= N && N <= 1000000))
            throw new IllegalArgumentException();

        boolean []isPrime=new boolean[N+1];
        Arrays.fill(isPrime,true);
        isPrime[1]=false;
        int multi=2;
        for(int idx=2;idx<=N;idx++){
            while(idx*multi<=N){
                isPrime[idx*multi]=false;
                multi++;
            }
            multi=2;
        }
        for(int i=M;i<=N;i++){
            if(isPrime[i])
                System.out.println(i);
        }
    }
}
/**
 * 방식1. 모든 수에 대해 for loop을 돌려서 자기 자신을 제외한 나머지 수에 대해 나눠 떨어지지 않으면 출력하는 방식
 * -> 실패(시간초과) ~> 수가 커지면 계산 횟수가 많아져 시간복잡도 M*N이 됨.. 비효율적
 *
 * 방식2. 에라토스테네스 ~> M*lg(N) 으로 줄어듬
 * 2부터 시작하여 자기 자신을 제외한 나머지 배수에 대해 모두 쳐내는 방식
 * 2를 제외한 나머지 2의 배수
 * 3을 제외한 나머지 3의 배수
 * ...
 *
 * 실수1. 숫자 입력 받을때 에외처리 통해 1을 필터링 한다 생각 했으나, 조건문 자체가 1을 포함하기 때문에 배열 초기화할때
 * 별도로 처리해줘야 했음.
 * 실수2. 배열 초기화 할때 메모리 용량이 초과하더라도 0~N 까지 정의하려 했으나 실제 코드 짤때 N-M+1로 함..주의!!
 */
