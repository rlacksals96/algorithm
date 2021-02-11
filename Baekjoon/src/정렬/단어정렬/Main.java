package 정렬.단어정렬;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        String[] str;
        int N=sc.nextInt();
        sc.nextLine();

        str=new String[N];
        for(int i=0;i<N;i++) {
            str[i] = sc.nextLine();
        }


        Arrays.sort(str,(s1, s2)->{
            //단어 길이가 같은경우
            if(s1.length()==s2.length())
                return s1.compareTo(s2);
            else
                return s1.length()-s2.length();
        });

        System.out.println(str[0]);
        for(int i=1;i<N;i++){
            if(!(str[i].equals(str[i-1])))
                System.out.println(str[i]);
        }


    }

}
