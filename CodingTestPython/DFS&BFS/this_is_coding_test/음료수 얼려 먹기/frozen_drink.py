from collections import deque

N, M = map(int, input().split())

graph = [list(map(int, input())) for _ in range(N)]


def dfs(x, y):
    if x <= -1 or x >= N or y <= -1 or y >= M:
        return False
    if graph[x][y] == 0:
        graph[x][y] = 1
        # 상,하,좌,우 재귀호출
        dfs(x - 1, y)
        dfs(x + 1, y)
        dfs(x, y - 1)
        dfs(x, y + 1)
        return True
    return False


def bfs(x,y):
    if graph[x][y]==1:
        return False

    graph[x][y]=1
    queue=deque()
    queue.append((x,y))
    # n e s w
    dx=[-1,0,1,0]
    dy=[0,1,0,-1]
    while queue:
        x,y=queue.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if nx<0 or nx>=N or ny<0 or ny>=M:
                continue
            if graph[nx][ny]==1:
                continue
            graph[nx][ny]=1
            queue.append((nx,ny))
    return True

#### bfs version
result=0
for i in range(N):
    for j in range(M):
        if bfs(i,j):
            result+=1
for g in graph:
    print(g)
print(result)

##### dfs version
# result=0
# for i in range(N):
#     for j in range(M):
#         if dfs(i, j):
#             result += 1
# print(result)

# sample data

# 4 5
# 00110
# 00011
# 11111
# 00000