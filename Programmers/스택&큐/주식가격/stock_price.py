# 못풀겟음..
def solution(prices):

    answer = [0 for _ in range(len(prices))]
    prev=-1

    t=1
    for i in range(len(prices)):
        if prices[i] >= prev:
            for j in range(t):
                answer[j]+=1
        prev=prices[i]
        t+=1
    return answer

prices=[1, 2, 3, 2, 3]
print(solution(prices))