def solution(maps, p, r):

    n=len(maps)
    answer=float('inf')
    for i in range(n):
        for j in range(n):
            tmp=kill_monster(maps,i,j,n,p,r)
            if answer>tmp:
                answer=tmp

    return answer

def is_in_square(x,y,i,j,r,n):
    res=pow(abs(x-i),2)+pow(abs(y-j),2)
    if res<0 or res>n:
        return False
    if pow(abs(x-i),2)+pow(abs(y-j),2)<=pow(r//2,2):
        return True
    else:
        return False

def is_in_circle(x,y,i,j,r,n):
    r=r/2**0.5
    res= pow(x-i,2)+pow(y-j,2)
    if res<0 or res>n:
        return False
    if pow(x-i,2)+pow(y-j,2)<=pow(r,2):
        return True
    else:
        return False
def kill_monster(maps,x,y,n,p,r):
    set1=set()
    set2=set()

    for i in range(x-n//2,x+n//2):
        for j in range(y-n//2,y+n//2):
            if i<0 or j<0 or i>=n or j>=n:
                continue
            if not is_in_square(x,y,i,j,r,n):
                continue
            set1.add((i,j))
    for i,j in set1:
        if is_in_circle(x,y,i,j,r,n):
            set2.add((i,j))

    set1=set1.difference(set2)

    for k in set1:
        maps[k[0]][k[1]]-=p//2
    for k in set2:
        maps[k[0]][k[1]]-=p

    cnt=0
    for m in maps:
        for z in m:
            if z==0:
                cnt+=1
    return cnt

maps=[[1, 28, 41, 22, 25, 79, 4], [39, 20, 10, 17, 19, 18, 8], [21, 4, 13, 12, 9, 29, 19], [58, 1, 20, 5, 8, 16, 9], [5, 6, 15, 2, 39, 8, 29],[39, 7, 17, 5, 4, 49, 5], [74, 46, 8, 11, 25, 2, 11]]
p=19
r=6
print(solution(maps,p,r))