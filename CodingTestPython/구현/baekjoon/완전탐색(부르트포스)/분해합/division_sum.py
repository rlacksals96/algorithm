import sys
input = lambda: sys.stdin.readline().rstrip()

ans=0
N=int(input())
for i in range(1,N+1):
    # list(map(int,input().split())) 에서
    # input().split()=1 2 3 -> 1 2 3을 문자열로 받은 후 타입을 int로 변경하는 작업을 한다는 점을 활용
    myList=list(map(int,str(i)))
    ans=i+sum(myList)
    if ans==N:
        print(i)
        break
    if i==N:
        print(0)
