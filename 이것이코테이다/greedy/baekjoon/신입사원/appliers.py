import sys

input = lambda: sys.stdin.readline().rstrip()

t = int(input())
for _ in range(t):
    n = int(input())

    # appliers = sorted([list(map(int, input().split())) for _ in range(n)], key=lambda x: x[0])
    # appliers.sort(key=lambda x: x[0])

    # 위 방식보다 아래 방식이 공간, 시간 복잡도 모두 더 낫다.
    appliers = [[0] * 2 for _ in range(n)]
    for i in range(n):
        appliers[i][0], appliers[i][1] = list(map(int, input().split()))

    appliers.sort(key=lambda x: x[0])
    cnt = 1
    min = appliers[0][1]

    for i in range(1, n):
        if appliers[i][1] < min:
            min = appliers[i][1]
            cnt += 1
    print(cnt)
