package 재귀;

public class Maze{
    private static int N=8;
    private static int [][] maze={
            {0,0,0,0,0,0,0,1},
            {0,1,1,0,1,1,0,1},
            {0,0,0,1,0,0,0,1},
            {0,1,0,0,1,1,0,0},
            {0,1,1,1,0,0,1,1},
            {0,1,0,0,0,1,0,1},
            {0,0,0,1,0,0,0,1},
            {0,1,1,1,0,1,0,0}
    };
    private static final int PATHWAY_COLOUR=0;
    private static final int WALL_COLOR=1;
    private static final int BLOCKED_COLOUR=2;
    private static final int PATH_COLOUR=3;

    public static void printPath(){
        for (int[] ints : maze) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean findPath(int x,int y){
        if(x<0 || y<0 || x>N-1 || y>N-1)
            return false;
        if(maze[x][y]!=PATHWAY_COLOUR)
            return false;
        else if(x==N-1 && y==N-1) {
            maze[x][y]=PATH_COLOUR;
            return true;
        }else{
            maze[x][y]=PATH_COLOUR;
            if(findPath(x+1,y)
            || findPath(x-1,y)
            || findPath(x,y+1)
            || findPath(x,y-1))
                return true;
            maze[x][y]=BLOCKED_COLOUR;
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println("before:");
        printPath();
        findPath(0,0);
        System.out.println("after");
        printPath();

    }
}