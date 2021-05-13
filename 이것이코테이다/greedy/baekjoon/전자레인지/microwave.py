import sys

input = lambda: sys.stdin.readline().rstrip()

t = int(input())
timer = [300, 60, 10]

result = []
for time in timer:
    if t < time:
        result.append(0)
    else:
        result.append(t // time)
        t %= time
if t == 0:
    print(str(result[0]) + " " + str(result[1]) + " " + str(result[2]))
else:
    print(-1)
