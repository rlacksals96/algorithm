import sys
from itertools import combinations

input = lambda: sys.stdin.readline().rstrip()
N, M = map(int, input().split())
cards = list(map(int, input().split()))
results = []

# 길이가 3인 부분집합
c = combinations(cards, 3)
results.extend(c)

# 부분집합의 합 구하고 내림차순으로 정렬
sum_results = list()
for res in results:
    sum_results.append(sum(res))
sum_results.sort(reverse=True)

# M보다 작거나 같은 값중 가장 큰 값
for s in sum_results:
    if s <= M:
        print(s)
        break
