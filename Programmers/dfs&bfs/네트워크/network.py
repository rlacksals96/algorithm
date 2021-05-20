from collections import deque


def solution(n, computers):
    answer=0
    visited=[False for _ in range(n)]

    for com in range(n):
        if visited[com]==False:
            bfs(n,computers,com,visited)
            answer+=1
    return answer
def bfs(n,computers, com,visited):
    visited[com]=True
    queue=deque()
    queue.append(com)
    while queue:
        item=queue.popleft()
        visited[item]=True
        for c in range(n):
            if c!=item and computers[item][c]==1:
                if visited[c]==False:
                    queue.append(c)

n=3
computers=[[1, 1, 0], [1, 1, 1], [0, 1, 1]]
print(solution(n,computers))