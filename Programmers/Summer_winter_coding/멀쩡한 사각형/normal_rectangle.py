# 미완성...
pos1=[]
pos2=[]
def formula(x,y,a):
    if y-1<=a*x<y:
        return True
def solution(w,h):
    a=h/w
    cnt=0
    # y를 기준
    for y in range(1,h+1):
        for x in range(w+1):
            if formula(x,y,a):
                pos1.append((a*x,y))
                cnt+=1
    for x in range(1,w+1):
        for y in range(h+1):
            if formula(x,y,a):
                pos2.append((x,y/a))
                cnt+=1
    answer=w*h-cnt
    return answer-1

w=8
h=12
pos1.sort(key=lambda x:(x[0].x[1]))
pos2.sort(key=lambda x:(x[0].x[1]))

print(solution(8,12))
print(pos1)
print(pos2)