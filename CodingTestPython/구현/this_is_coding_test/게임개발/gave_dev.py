# 진행중..

n, m = list(map(int, input().split()))

d = [[0] * m for _ in range(n)]
x, y, direction = map(int, input().split())
d[x][y] = 1

for i in range(n):
    tmp = list(map(int, input().split()))
    for idx, t in enumerate(tmp):
        d[i][idx] = t

# N E S W
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def turn_left():
    global direction
    if direction == 0:
        direction = 3
    else:
        direction -= 1


count = 1
turn_time = 0
while True:
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]
    # first visit
    if d[nx][ny] == 0:
        d[nx][ny] = 2
        x = nx
        y = ny
        count += 1
        turn_time = 0
        continue
    # 회전 후 가본칸이거나 바다인 경우
    else:
        turn_time += 1

    if turn_time == 4:
        nx = x - dx[direction]
        ny = y - dy[direction]
        # 뒤로 이동 가능한 경우
        if d[nx][ny] == 0:
            x = nx
            y = ny
        # 뒤가 바다인 경우
        else:
            break
        turn_time = 0

print(count)
