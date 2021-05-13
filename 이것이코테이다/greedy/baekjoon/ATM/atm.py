import sys

input=lambda :sys.stdin.readline().rstrip()

n=input()
data=list(map(int,input().split()))
data.sort()
sum=0
current=0

for d in data:
    current+=d
    sum+=current
print(sum)