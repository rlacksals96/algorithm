import sys

n, m, k = list(map(int, input().split()))
arr = list(map(int, input().split()))
arr.sort(reverse=True)


# sum = 0
# cnt = k
# for i in range(m):
#     if(cnt==0):
#         cnt=k
#         sum+=arr[1]
#         continue
#     sum+=arr[0]
#     cnt-=1
# print(sum)

count = int(m / (k + 1)) * k
count += m % (k + 1)

result = 0
result += count * arr[0]
result += (m - count) * arr[1]

print(result)
