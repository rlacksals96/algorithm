import sys

input = lambda: sys.stdin.readline().rstrip()
n = int(input())


def func(n):
    cnt = 0
    while n > 0:
        while n % 5 != 0:
            n -= 3
            cnt += 1
            if n < 0:
                return -1
        cnt += n // 5
        return cnt


result = func(n)
print(result)
