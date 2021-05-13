import sys

input = lambda: sys.stdin.readline().rstrip()

n, k = list(map(int, input().split()))
coin = []
for _ in range(n):
    tmp = int(input())
    coin.append(tmp)
coin.sort(reverse=True)

cnt = 0
for c in coin:
    if c > k:
        continue
    else:
        cnt += k // c
        k %= c
print(cnt)
