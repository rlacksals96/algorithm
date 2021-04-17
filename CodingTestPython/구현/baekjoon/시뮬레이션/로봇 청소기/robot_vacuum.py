#give up...
import sys

input = lambda: sys.stdin.readline().rstrip()


global maps
# N E S W
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def turn_left():
    global d
    if d == 3:
        d = 0
    else:
        d += 1

def check_boundary(x,y):
     if 0<=x<n and 0<=y<m:
         return True
     else:
         return False

def clean(x,y,d):
    maps[x][y]=2
    cnt=1

    while True:
        for i in range(4):
            turn_left()
            nx=x+dx[d]
            ny=y+dy[d]
            if check_boundary(nx,ny) and maps[nx][ny]==0:
                cnt+=1
                maps[nx][ny]=2
                x=nx
                y=ny
                break
            if i==3:
                nx=x-dx[d]
                ny=y-dy[d]
                if maps[nx][ny]==1:
                    print(cnt)
                else:
                    x=nx
                    y=ny








if __name__=="__main__":
    n, m = map(int, input().split())
    r, c, d = map(int, input().split())
    maps = [list(map(int, input().split())) for _ in range(n)]
    cnt=0
    clean(r,c,d)