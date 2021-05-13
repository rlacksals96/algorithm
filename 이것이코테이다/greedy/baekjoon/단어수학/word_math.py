import sys

input = lambda: sys.stdin.readline().rstrip()

n = int(input())
dic = dict()
words = []

for _ in range(n):
    words.append(input())

for word in words:
    k = len(word) - 1

    # 글자의 위치에 따라 10^N 꼴로 표현하기 떄문에 각 글자별로 대소 비교 가능
    # ABC -> A=100, B=10, C=1
    # AB -> A,B 모두 등록이 되어 있으므로 A=100+10, B=10+1 이 됨.
    # 가장 큰 값*9, 다음 값 *8 ...
    for s in word:
        if s in dic:
            dic[s] += pow(10, k)
        else:
            dic[s] = pow(10, k)
        k -= 1

nums = []

for value in dic.values():
    nums.append(value)
nums.sort(reverse=True)

result, t = 0, 9

for num in nums:
    result += num * t
    t -= 1

print(result)
