from collections import deque


# 다익스트라 알고리즘을 사용한다.
# 출발노드의 거리0, 나머지 노드 무한으로 설정하고
# bfs로 인접 노드 탑색. 현재 노드에서 노드간 거리를 더해준 값이 저장된 값보다
# 작으면 갱신후 queue에 추가
def solution(N, road, K):
    nodes = {}
    # float('inf') -> 조건 성립 안하면 '무한'으로 설정한다.

    dist = {i: float('inf') if i != 1 else 0 for i in range(1, N + 1)}
    for v1, v2, d in road:
        # get(key,[value]) -> 값이 없으면 list [] 생성.
        # nodes={ 1: [(destination, distance)] }
        nodes[v1] = nodes.get(v1, []) + [(v2, d)]
        nodes[v2] = nodes.get(v2, []) + [(v1, d)]
    que = deque([1])

    while que:
        cur_node = que.popleft()
        for next_node, d in nodes[cur_node]:
            if dist[next_node] > dist[cur_node] + d:
                dist[next_node] = dist[cur_node] + d
                que.append(next_node)

    return len([True for dist in dist.values() if dist <= K])


N = 6
road = [[1, 2, 1], [1, 3, 2], [2, 3, 2], [3, 4, 3], [3, 5, 2], [3, 5, 3], [5, 6, 1]]
K = 4
print(solution(N, road, K))
