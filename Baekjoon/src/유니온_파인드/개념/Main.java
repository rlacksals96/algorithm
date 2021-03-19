package 유니온_파인드.개념;

public class Main {
    private static int []parent;
    public static void main(String[] args) {
        parent=new int[10];
        for(int i=0;i<parent.length;i++)
            parent[i]=i;

        unionParent(1,2);
        unionParent(2,3);
        unionParent(4,5);
        unionParent(5,6);
        unionParent(6,8);
        unionParent(7,0);
        //1-2-3  4-5-6-8  7-0
        System.out.println("find parent");
        System.out.println(2+" "+3);
        System.out.println(findParent(2,3));

        System.out.println("get parent of 8");
        System.out.println(getParent(8));

    }
    public static void unionParent(int a,int b){
       a=getParent(a);
       b=getParent(b);
       if(a>b)
           parent[a]=b;
       else
           parent[b]=a;
    }
    public static boolean findParent(int a,int b){
        if(parent[a]==parent[b])
            return true;
        else
            return false;
    }
    public static int getParent(int a){
        if(parent[a]==a)
            return a;
        return parent[a]=getParent(parent[a]);
    }

}
