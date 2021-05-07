import heapq
# 최소값을 활용하는 문제의 경우 heapq를 애용하자
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while len(scoville)>=2:
        item=heapq.heappop(scoville)+heapq.heappop(scoville)*2

        heapq.heappush(scoville,item)
        answer+=1
        if scoville[0]>=K:
            return answer
    if scoville[0]>=K:
        return answer
    else:
        return -1



scoville=[1, 2, 3, 9, 10, 12]
K=7
print(solution(scoville,K))