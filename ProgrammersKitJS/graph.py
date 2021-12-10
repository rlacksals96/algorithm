from collections import deque


def search_by_bfs(x,y):
    queue=deque()
    queue.append((x,y))
    arr[x][y]=0
    while queue:
        cx,cy=queue.popleft()
        for i in range(4):
            tx,ty=cx+dx[i],cy+dy[i]
            if 0<=tx<N and 0<=ty<M:
                if arr[tx][ty]==1:
                    queue.append((tx,ty))
                    arr[tx][ty]=0
# N E S W
dx=[-1,0,1,0]
dy=[0,1,0,-1]

T=int(input())
result=list()

for t in range(T):
    M,N,K=list(map(int,input().split()))
    arr=[[0]*M for _ in range(N)]
    for _ in range(K):
        x,y=list(map(int,input().split()))
        arr[y][x]=1


    print()
    print("trial: {}".format(t+1))
    for i in range(N):
        print(arr[i])


    cnt=0
    for j in range(M):
        for i in range(N):
            if arr[i][j]==1:
                search_by_bfs(i,j)
                cnt+=1
    result.append(cnt)
    cnt=0
for r in result:
    print(r)
