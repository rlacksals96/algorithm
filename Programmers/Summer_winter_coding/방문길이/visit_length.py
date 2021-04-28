def solution(dirs):
    # answer = 0
    x, y = 0, 0
    # U D R L
    dx = {'U': 0, 'D': 0, 'R': 1, 'L': -1}
    dy = {'U': 1, 'D': -1, 'R': 0, 'L': 0}
    visited = list()

    for dir in dirs:
        px = x + dx[dir]
        py = y + dy[dir]
        if -5 <= px <= 5 and -5 <= py <= 5:
            if (x, y, px, py) not in visited and (px, py, x, y) not in visited:
                visited.append((x, y, px, py))
            x = px
            y = py
    return len(visited)


dirs = "LULLLLLLU"
print(solution(dirs))
