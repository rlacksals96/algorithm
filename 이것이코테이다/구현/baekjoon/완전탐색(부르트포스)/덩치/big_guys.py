import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())
persons = []

for i in range(n):
    tmp = list(map(int, input().split()))
    tmp.append(1)
    persons.append(tmp)

for i in range(n):
    for j in range(n):
        if persons[i][0] < persons[j][0] and persons[i][1] < persons[j][1]:
            persons[i][2] += 1

result = list()
for p in persons:
    result.append(p[2])
for r in result:
    print(r, end=' ')
