from itertools import permutations

def solution(numbers):

# 내 방식
    case=set()
    for r in range(1,len(numbers)+1):
        case.update(permutations(numbers,r))

    result=[]
    for c in case:
        result.append(''.join(c))

    result=set(map(int,result))


    cnt = find_prime(result)

# 모법 답안 방식 #######
    a=set()
    for i in range(len(numbers)):
        a|=set(map(int,map(''.join,permutations(list(numbers),i+1))))
    a-=set(range(0,2))
    cnt=find_prime(a)
#############


    return cnt

def find_prime(result):
    cnt=0
    for num in result:
        if num<2:
            continue
        for i in range(2,num-1):
            if num%i==0:
                break
        else:
            cnt+=1
    return cnt
numbers="17"
print(solution(numbers))