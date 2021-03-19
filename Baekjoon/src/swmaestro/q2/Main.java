package swmaestro.q2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        int p=Integer.parseInt(str[0]);//pc cnt
        int n=Integer.parseInt(str[1]);//client
        int h=Integer.parseInt(str[2]);//hope time
        int []profit=new int[p+1];
        Arrays.fill(profit,0);
        Reservation []r=new Reservation[n];
        for(int i=0;i<n;i++){
            String []tmp=br.readLine().split(" ");
            //번호 시간
            r[i]=new Reservation(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]));
        }
        Arrays.sort(r);
        //정렬
        for(int i=0;i<r.length;i++){
            if(r[i].getHour()<=h){
                profit[r[i].getNum()]+=r[i].getHour()*1000;
                h-=r[i].getHour();
            }
        }

        for(int i=1;i<profit.length;i++){
            System.out.println(i+" "+profit[i]);
        }

    }
}
class Reservation implements Comparable{
    int num;
    int hour;
    Reservation(int num,int hour){
        this.num=num;
        this.hour=hour;
    }



    public int getNum() {
        return num;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public int compareTo(Object o) {
        Reservation r=(Reservation) o;
        if(hour>((Reservation) o).hour)
            return -1;
        else
            return 1;

    }
}
