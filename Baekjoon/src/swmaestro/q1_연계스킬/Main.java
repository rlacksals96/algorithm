package swmaestro.q1_연계스킬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//실패.............................
public class Main{

    private static SkillMap[] skillsMap;
    private static int []skills;
    private static boolean []isSingle;
    private static boolean isFirst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] k = br.readLine().split(" ");
        skills = new int[k.length];
        isSingle = new boolean[k.length];
        skillsMap =new SkillMap[k.length];
        Arrays.fill(isSingle, true);
        for (int i = 0; i < skills.length; i++)
            skills[i] = i;
        //전체 스킬 map에 저장하기
        for (int i = 0; i < k.length; i++) {
            skillsMap[i]=new SkillMap(i,k[i]);
        }
        int n = Integer.parseInt(br.readLine());
        int a=0,b=0;
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");

            for(SkillMap sm:skillsMap){
                if(sm.getSkillName().equals(tmp[0])) {
                    a = sm.getSkillNum();
                    break;
                }
            }
            for(SkillMap sm:skillsMap){
                if(sm.getSkillName().equals(tmp[1])){
                    b=sm.getSkillNum();
                    break;
                }
            }
//            isSingle[a] = false;
            isSingle[b] = false;
            unionParent(a, b);
            for (int j = 0; j < isSingle.length; j++) {
                if (isSingle[j]) {
                    isFirst=true;
                    findLink(j);
                }
                isFirst=true;//다음 회에서 리셋해야 하니까..
            }
        }
        //연결 관계 맵핑 완료

    }
    public static void findLink(int a){
        if(skills[a]==a && isFirst)
            return;
        if(skills[a]==a){
            System.out.println(skillsMap[a].getSkillName());
            return;
        }
        isFirst=false;
        System.out.print(skillsMap[a].getSkillName()+ " ");
        findLink(skills[a]);
    }
    public static void unionParent(int a,int b){
        a=getParent(a);
        b=getParent(b);
        if(a<b)
            skills[a]=b;
        else
            skills[b]=a;
    }
    public static int getParent(int a){
        if(skills[a]==a)
            return a;
        else
            return skills[a]=getParent(skills[a]);
    }
    public static boolean findParent(int a,int b){
        if(skills[a]==skills[b])
            return true;
        else
            return false;
    }
}

class SkillMap{
    private String skillName;
    private int skillNum;
    public SkillMap(int skillNum,String skillName) {
        this.skillNum=skillNum;
        this.skillName=skillName;
    }

    public int getSkillNum() {
        return skillNum;
    }

    public String getSkillName() {
        return skillName;
    }
}