import sys
from itertools import combinations

input = lambda: sys.stdin.readline().rstrip()

dwarfs = list()

for _ in range(9):
    dwarfs.append(int(input()))

cands = list(combinations(dwarfs, 7))

for c in cands:
    result = list(c)
    if sum(result) == 100:
        result.sort()
        for r in result:
            print(r)
        break
