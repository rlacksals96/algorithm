from itertools import combinations


def check_combi(c):
    num = sum(c)
    for i in range(2, num):
        if num % i == 0:
            return False
    return True


def solution(nums):
    answer = 0
    combis = combinations(nums, 3)
    for c in combis:
        if check_combi(c):
            answer += 1
    return answer


nums = list(map(int, input().split()))

print(solution(nums))
