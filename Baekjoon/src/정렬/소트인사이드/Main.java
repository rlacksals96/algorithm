package 정렬.소트인사이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        String str=st.nextToken();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<str.length();i++){
           arr.add(str.charAt(i)-'0');
        }
        Collections.sort(arr);
        for(int i=arr.size()-1;i>=0;i--)
            System.out.print(arr.get(i));

    }
}
