# dfs는 스택을 쓰는 알고리즘이기 때문에 실제 구현은 재귀 함수로 사용하면 간결하게 구현할수 있다.
# 탐색시간 O(N)
def dfs(graph,v, visited):
    visited[v]=True
    print(v,end=' ')
    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited)

graph=[
    [],
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]
# 노드별 방문 정보
visited=[False]*9

dfs(graph,1,visited)