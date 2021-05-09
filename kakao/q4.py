def solution(n, start, end, roads, traps):

    visited=[False for _ in range(n+1)]
    visited[0]=True
    visited[start]=True
    dp=[float("inf") for _ in range(n+1)]
    # answer = 0
    dp[0]=0
    dp[start]=0
    current=start
    while current!=end:
        for road in roads:

            if road[0]==current and visited[road[1]]==False:

                if road[1] not in traps:
                    visited[road[1]]=True
                current=road[1]
                if dp[road[1]]>dp[road[0]]+road[2]:
                    dp[road[1]] = dp[road[0]] + road[2]
                if current in traps:
                    switch_roads(roads)


            if current==end:
                break

    print(dp)
    return 1


def switch_roads(roads):
    for road in roads:
        road[0],road[1]=road[1],road[0]

n=4
start=1
end=4
roads=[[1, 2, 1], [3, 2, 1], [2, 4, 1]]
traps=[2, 3]
print(solution(n,start,end,roads,traps))