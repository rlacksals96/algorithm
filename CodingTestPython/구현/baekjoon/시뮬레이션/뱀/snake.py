import sys
input = lambda: sys.stdin.readline().rstrip()


def make_turn(current_direction, request_direction):
    # n e s w 0 1 2 3
    if request_direction == 'D':  # right
        if current_direction == 3:
            current_direction = 0
        else:
            current_direction += 1
    else:  # left
        if current_direction == 0:
            current_direction = 3
        else:
            current_direction -= 1

    return current_direction


def check_boundary(n, nx, ny):
    if 0 <= nx < n and 0 <= ny < n:
        return True
    else:
        return False


if __name__ == '__main__':

    n = int(input())
    maps = [[0] * n for _ in range(n)]
    k = int(input())
    apples = []
    turns = {}

    # 사과좌표
    for i in range(k):
        r,c=map(int,input().split())
        maps[r-1][c-1]=1

    # 회전좌표
    l = int(input())
    for _ in range(l):
        x,c=input().split()
        turns[int(x)]=c


    # N E S W
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    # east
    x, y = 0, 0
    d = 1
    # snake information
    snake = list()

    snake.append([0, 0])  # left is tail, right is head

    # 현재 시간 표시
    current_time = 0

    while True:
        # 기본
        x += dx[d]
        y += dy[d]
        current_time += 1

        # 회전할 떄 된경우.
        if current_time in turns.keys():
            d = make_turn(d, turns[current_time])

        # 범위 확인
        if check_boundary(n,x,y):
            # 자기 건드리는 경우.
            if [x,y] in snake:
                break

            # 사과 먹는 경우
            if maps[x][y] == 1:
                maps[x][y] = 0
                snake.append([x,y])

            # 사과가 없는 경우
            elif maps[x][y]==0:
                snake.append([x,y])
                snake.pop(0)
        else:
            break

    print(current_time)