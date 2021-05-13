import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

N = int(input())
# n e s w
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
cnt=0

def count_block(x, y):
    global cnt
    cnt+=1
    visited[x][y]=True

    for i in range(4):
        nx,ny=x+dx[i],y+dy[i]
        if 0<=nx<N and 0<=ny<N:
            if graph[nx][ny]==1 and visited[nx][ny]==False:
                count_block(nx,ny)


result = []
graph = [list(map(int, input())) for _ in range(N)]
visited=[[False] *N for _ in range(N)]


for i in range(N):
    for j in range(N):
        if graph[i][j] == 1 and visited[i][j]==False:
            cnt=0
            count_block(i,j)
            result.append(cnt)


print(len(result))
result.sort()
for r in result:
    print(r)
