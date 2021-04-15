import sys

input = sys.stdin.readline
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

ans = 0

def update_direction(direction):
    if direction==3:
        return 0
    else:
        return direction-1

def clean(x,y,d):
    cnt=1
    arr[x][y]=2
    while True:
        for _ in range(4):
            nd=update_direction(nd)
            nx=x+dx[nd]
            ny=y+dy[nd]
            d=nd
            if arr[nx][ny]==0:
                arr[nx][ny]=2
                cnt+=1
                break


if __name__=="__main__":
    n, m = map(int, input().split())
    r, c, d = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]

    clean(r,c,d)
    global ans
    print(ans)