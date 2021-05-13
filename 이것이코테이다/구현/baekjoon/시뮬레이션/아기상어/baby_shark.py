# 중단...
import sys

input=lambda :sys.stdin.readline().strip()

N=int(input())
maps=[list(map(int,input().split())) for _ in range(N)]
shark_size=2
cnt_eaten_fish=0
cnt_fish=0
time_cnt=0

fish_info=[]
# 상어 시작 위치 & 물고기 갯수 세기
x,y=0,0
for i in range(N):
    for j in range(N):
        if maps[i][j]==9:
            x,y=i,j
        if 1<=maps[i][j]<=6:
            tmp=[]
            cnt_fish+=1
            tmp.append(i)
            tmp.append(j)
            tmp.append(maps[i][j])
            fish_info.append(tmp) # (x,y),size 입력

while fish_info:
    # 물고기 크기, 거리, 좌상 여부,
    fish_info.sort(key=lambda k: (abs(x - k[0]) + abs(y - k[1]), k[0],k[1]))
    flag=True

    fish=0
    print(fish_info)
    # 먹을 고기 있는지 확인
    for i in range(len(fish_info)):
        if fish_info[i][2]<shark_size:
            fish=fish_info.pop(i)
            flag=True
            break
        flag=False
    # 먹을 고기 없으면 중단.
    if not flag:
        break



    time_cnt+=abs(x-fish[0])
    time_cnt+=abs(y-fish[1])
    x=fish[0]
    y=fish[1]
    cnt_eaten_fish+=1
    if shark_size==cnt_eaten_fish:
        shark_size+=1
        cnt_eaten_fish=0
    print("fish: ",end=" ")
    print(fish)
    print("time: "+str(time_cnt))
    print("shark size: "+str(shark_size))
    print("cnt_eaten_fish: "+str(cnt_eaten_fish))

print(time_cnt)