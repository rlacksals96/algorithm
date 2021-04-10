m, n = list(map(int, input().split()))
result=0
for i in range(m):
    li = list(map(int, input().split()))
    min_value = min(li)
    result=max(result,min_value)

print(result)
