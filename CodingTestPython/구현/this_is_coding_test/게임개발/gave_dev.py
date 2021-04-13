#solving

import sys
input=lambda :sys.stdin.readline().rstrip()

M,N=list(map(int,input().split()))
A,B,d=list(map(int,input().split()))
maps=[[0]*N for _ in range(M)]

direction=[0,1,2,3] # N E S W
go_left=[[0,-1],[-1,0],[0,1],[1.0]]
cnt=0
for n in range(N):
    tmp=list(map(int,input().split()))
    for m in range(M):
        maps[n][m]=tmp[m]
px=A
py=B

while True:
    tmpX=px+go_left[d][0]
    tmpY=py+go_left[d][1]
    if tmpX < 0 or tmpX > N or tmpY < 0 or tmpY > M:
        tmpX = px - go_left[d][0]
        tmpY = py - go_left[d][1]
    if d==3:
        d=0
    else:
        d+=1



