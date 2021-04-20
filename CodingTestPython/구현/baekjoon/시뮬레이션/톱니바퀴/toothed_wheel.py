import sys
from collections import deque

input = lambda: sys.stdin.readline()


def turn_right(w, d):
    if w > 4 or wheels[w - 1][2] == wheels[w][6]:
        return

    if wheels[w - 1][2] != wheels[w][6]:
        turn_right(w + 1, d * (-1))
        wheels[w].rotate(d)


def turn_left(w, d):
    if w < 1 or wheels[w][2] == wheels[w + 1][6]:
        return

    if wheels[w + 1][6] != wheels[w][2]:
        turn_left(w - 1, d * (-1))
        wheels[w].rotate(d)


if __name__ == "__main__":
    wheels = {}
    for i in range(1, 5):
        wheels[i] = deque(list(map(int, list(input().replace("\n", "")))))

    k = int(input())
    for _ in range(k):
        w, d = map(int, input().split())
        turn_right(w + 1, d * (-1))
        turn_left(w - 1, d * (-1))
        wheels[w].rotate(d)
    sum = 0
    for i in range(4):
        sum += (2 ** i) * wheels[i + 1][0]
    print(sum)
