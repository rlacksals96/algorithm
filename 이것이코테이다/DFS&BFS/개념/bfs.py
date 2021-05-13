# 큐 자료구조를 사용
# 탐색시간 O(N)
# 일반적인 경우 실제 수행 시간은 DFS보다 좋은 편이다.
# 코테에서 탐색 문제 나오면 그래프 형태로 표현한 담에 dfs || bfs 고민해보면 좋을거야.
from collections import deque


def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]
visited = [False] * 9

bfs(graph, 1, visited)
