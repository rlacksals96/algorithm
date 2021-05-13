import sys

input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
x, y, d = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(n)]

# N E S W
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def turn_left():
    global d
    if d == 3:
        d = 0
    else:
        d += 1

def main():
    global x,y,d
    cnt=0
    turn_cnt=0
    while True:
        turn_left()
        tx=x+dx[d]
        ty=y+dx[d]
        if maps[tx][ty]==0:
            x=tx
            y=ty
            maps[x][y]=2
            cnt+=1
        else:
            turn_cnt+=1

        if turn_cnt==4:
            tx=x-dx[d]
            ty=x-dy[d]
            if maps[tx][ty]==0:
                x=tx
                y=ty
            else:
                break
            turn_cnt=0

    print(cnt)
if __name__=="__main__":
    main()