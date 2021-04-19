import sys
import copy

input = lambda: sys.stdin.readline().rstrip()

# 0 E W N S
# 방향 전환이 1부터 시작해서 0은 위치 맞추기용.
dx = [0, 0, 0, -1, 1]
dy = [0, 1, -1, 0, 0]
dice = [0 for _ in range(7)]


def role_dice(direction):
    temp = copy.deepcopy(dice)
    if direction == 1:
        dice[1] = temp[4]
        dice[3] = temp[1]
        dice[4] = temp[6]
        dice[6] = temp[3]
    elif direction == 2:
        dice[1] = temp[3]
        dice[3] = temp[6]
        dice[4] = temp[1]
        dice[6] = temp[4]
    elif direction == 3:
        dice[1] = temp[5]
        dice[2] = temp[1]
        dice[5] = temp[6]
        dice[6] = temp[2]
    elif direction == 4:
        dice[1] = temp[2]
        dice[2] = temp[6]
        dice[5] = temp[1]
        dice[6] = temp[5]


def check_boundary(x, y):
    return True if 0 <= x < n and 0 <= y < m else False


if __name__ == "__main__":
    n, m, x, y, k = map(int, input().split())

    maps = list()
    for _ in range(n):
        maps.append(list(map(int, input().split())))

    orders = list(map(int, input().split()))
    # E W N S 1 2 3 4
    for order in orders:
        tx = x + dx[order]
        ty = y + dy[order]
        if not check_boundary(tx, ty):
            continue

        x = tx
        y = ty
        role_dice(order)
        # print(str(x)+","+str(y)+",")
        print(dice[1])

        if maps[x][y] == 0:
            maps[x][y] = dice[6]
        else:
            dice[6] = maps[x][y]
            maps[x][y] = 0
