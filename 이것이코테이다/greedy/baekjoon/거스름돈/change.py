import sys

input = lambda: sys.stdin.readline().rstrip()

price = int(input())
change = 1000 - price

coin = [500, 100, 50, 10, 5, 1]

cnt = 0
for c in coin:
    if change == 0:
        break
    cnt += change // c
    change %= c

print(cnt)
