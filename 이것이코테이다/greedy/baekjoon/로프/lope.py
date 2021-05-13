import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())
lopes = []
for _ in range(n):
    lopes.append(int(input()))

lopes.sort()

length = n
available_weight = -1
for i in range(n):
    if available_weight < lopes[i] * length:
        available_weight = lopes[i] * length
    length-=1

print(available_weight)
