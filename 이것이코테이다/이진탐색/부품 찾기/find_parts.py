
# 두가지 해결 방식(집함 자료구조 활용, 이진탐색 방법) 모두 적절한 해결 방식이라 할 수 있으며 특별히 어떤 방식이 더 뛰어나다 보긴 어렵다


def solved_by_set(n,inventories,m,requirements):
    result=''
    for r in requirements:
        if r in inventories:
            result+='yes '
        else:
            result+='no '

    print(result.rstrip())

# 시간복잡도 O((M+N) * log N)
def solved_by_bin_search(arr,target,start,end):

    while start<=end:
        mid=(start+end)//2

        if arr[mid]==target:
            return mid
        elif arr[mid]>target:
            end=mid-1
        else:
            start=mid+1
    return None
n=int(input())
inventories=list(map(int,input().split(' ')))
m=int(input())
requirements=list(map(int,input().split(' ')))

# 집합 자료구조로 해결하기
solved_by_set(n,set(inventories),m,requirements)

# 이진 탐색 기법을 parametric search 방식으로 변형하여 해결하기.
inventories.sort()
result=''
for r in requirements:
    if solved_by_bin_search(inventories,r,0,n-1) is None:
        result+="no "
    else:
        result+='yes '
print(result.rstrip())


# 5
# 8 3 7 9 2
# 3
# 5 7 9