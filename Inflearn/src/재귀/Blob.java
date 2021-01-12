package 재귀;
//counting cells in a blob
//blob: 서로 연결된 img pixel들의 집합(대각 방향 포함)
//특정 좌표가 blob인지 확인하고 인근의 blob들 갯수 및 형태 확인 가능
public class Blob {
    private static final int BACK_GROUND=0;
    private static final int IMAGE_COLOR=1;
    private static final int ALREADY_COUNTED=2;

    private static final int N=8;
    private static final int [][] pixel={
            {1,0,0,0,0,0,0,1},
            {0,1,1,0,0,1,0,0},
            {1,1,0,0,1,0,1,0},
            {0,0,0,0,0,1,0,0},
            {0,1,0,1,0,1,0,0},
            {0,1,0,1,0,1,0,0},
            {1,0,0,0,1,0,0,1},
            {0,1,1,0,0,1,1,1}
    };
    public static int countCell(int x,int y){
        if(x<0 || y<0 || x>N-1 || y>N-1)
            return 0;
        if(pixel[x][y]!=IMAGE_COLOR)
            return 0;
        else{
            pixel[x][y]=ALREADY_COUNTED;
            return 1+countCell(x,y+1)
                    +countCell(x+1,y+1)
                    +countCell(x+1,0)
                    +countCell(x+1,y-1)
                    +countCell(x,y-1)
                    +countCell(x-1,y-1)
                    +countCell(x-1,y)
                    +countCell(x-1,y+1);
        }
    }
    public static void printPixel(){
        for (int[] ints : pixel) {
            for (int j = 0; j < pixel[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("before:");
        printPixel();
        int result=countCell(1,5);
        System.out.println("result: "+result);
        System.out.println("after:");
        printPixel();

    }
}
