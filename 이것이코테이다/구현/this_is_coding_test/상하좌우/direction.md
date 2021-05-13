#상하좌우

문제 

여행가 A는 N × N 크기의 정사각형 공간 위에 서 있다. 이 공간은 1 × 1 크기의 정사각형으로 나누어져 있다.
가장 왼쪽 위 좌표는 (1, 1)이며, 가장 오른쪽 아래 좌표는 (N, N)에 해당한다.
여행가 A는 상, 하, 좌, 우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1, 1)이다. 우리 앞에는 여행가 A가
이동할 계획이 적힌 계획서가 놓여 있다

계획서에는 하나의 줄에 띄어쓰기를 기준으로 L, R, U, D 중 하나의 문자가 반복적으로 적혀있다.
각 문자의 의미는 다음과 같다

L: 왼쪽으로 한 칸 이동

R: 오른쪽으로 한 칸 이동

U: 위로 한 칸 이동

D: 아래로 한 칸 이동

이때 여행가 A가 N × N 크기의 정사각형 공간을 벗어나는 움직임은 무시된다
예를 들어 (1, 1)의 위치에서 L 혹은 U를 만나면 무시된다
다음은 N = 5인 지도와 계획이다

![screenshot](https://blog.kakaocdn.net/dn/JevIm/btqMdEcJFLe/ZTi7Kp6pGsm2noBYQ52uF0/img.png)
![screenshot](https://blog.kakaocdn.net/dn/Xc92c/btqMbYQ1xdm/e9Oa6pYbfLYulSWuXxld3k/img.png)

---
 좌표문제에서 가장 간단하게 방향 이동을 보여주는 방법은 if-else 구문을 활용하여 범위를 넘어가는 경우 continue를 사용하여 구현하는 방법이다.
 
```python
type = ['L','R','U','D']

for i in range(len(plan)):
    if plan[i] == type[0]:
        if y -1 == 0:
            continue
        else:
            y = y - 1
    
    # 밑은 생략
```
다만 해당 방식의 경우 가독성이 떨어지는 방식이다.

주어진 명령어에 대응하는 액션을 리스트에 넣어 놓고 해당 명령어가 나오면 대응하는 처리하는 방식을 사용하는 것이 가독성이 더 뛰어나다.

```python
# L,R,U,D에 따른 이동 방향
dx=[0,0,-1,1]
dy=[-1,1,0,0]
move_types=['L','R','U','D']

nx,ny=0,0
for plan in plans:
    for i in range(len(move_types)):
        if plan==move_types[i]:
            nx=x+dx[i]
            ny=y+dy[i]
        if nx<1 or ny<1 or nx>n or ny>n:
            continue
        x,y=nx,ny
print(x, y)
```