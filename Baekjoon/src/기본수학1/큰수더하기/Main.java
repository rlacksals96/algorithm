package 큰수더하기;

import java.util.Scanner;

public class Main {
    private String A, B;
    private String sum;

    public String getSum() {
        return sum;
    }

    public Main(String A, String B) {
        this.A = A;
        this.B = B;
        sum = "";
    }

    // 문자열의 길이를 통일시켜주기 위해 길이가 짧은 수의 앞에 '0' 추가
    public void compare() {
        int diff = Math.abs(A.length() - B.length());
        String tmp = "";
        for (int i = 0; i < diff; i++)
            tmp = "0" + tmp;
        if (A.length() >= B.length())
            B = tmp + B;
        else
            A = tmp + A;

    }

    // 각 자리마다 계산하되 합이 10을 넘어가면 +1
    public void calculate() {
        int tmp = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            int a = A.charAt(i) - '0';
            int b = B.charAt(i) - '0';
            tmp = addNDigit(a, b, tmp);
        }
        if (tmp == 1)
            sum = "1" + sum;
    }

    // n자리 맞춰서 계산
    public int addNDigit(int a, int b, int tmp) {
        int k = a + b + tmp;
        int l = k % 10;
        String m = Integer.toString(l);
        sum = m + sum;
        return k / 10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        Main ai = new Main(A, B);
        ai.compare();
        ai.calculate();
        System.out.println(ai.getSum());

    }

}
