n = list(map(str, input()))

px = [2, 2, -2, -2, 1, -1, 1, -1]  # col
py = [1, -1, 1, -1, 2, 2, -2, -2]  # row

# ascii 97='a' 104='h'

cnt = 0

for i in range(8):
    tmpX = ord(n[0]) + px[i]
    tmpY = int(n[1]) + py[i]
    if tmpX < 97 or tmpX > 104 or tmpY < 1 or tmpY > 8:
        continue
    else:
        cnt += 1

print(cnt)
