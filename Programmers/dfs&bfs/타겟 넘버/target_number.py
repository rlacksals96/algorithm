# dfs로 풀어야 하는데 그리디로 풀어버렸누..
cnt=0
def find_case(numbers,target,idx,result):
    global cnt
    if idx==len(numbers)-1:
        if result==target:
            cnt+=1
        return

    find_case(numbers,target,idx+1,result+numbers[idx])
    find_case(numbers,target,idx+1,result-numbers[idx])


def solution(numbers, target):
    find_case(numbers,target,-1,0)
    answer=cnt
    return answer

numbers=[1, 1, 1, 1, 1]
target=3
print(solution(numbers,target))