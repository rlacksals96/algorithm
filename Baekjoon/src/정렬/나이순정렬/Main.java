package 정렬.나이순정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        Member []members=new Member[N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int age=Integer.parseInt(st.nextToken());
            String name=st.nextToken();
            members[i]=new Member(i,age,name);
        }
        Arrays.sort(members);
        for(Member m:members)
            System.out.println(m.getAge()+" "+m.getName());

    }
}
class Member implements Comparable{
    private int index;
    private int age;
    private String name;

    public int getIndex() {
        return index;
    }

    public Member(int index, int age, String name) {
        this.index = index;
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        Member member=(Member)o;

        if(age>member.age)
            return 1;
        else if(age<member.age)
            return -1;
        else{
            return Integer.compare(index,member.index);
        }
    }
}
