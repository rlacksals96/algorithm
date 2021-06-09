n, m = list(map(int, input().split()))
coins = list()
for _ in range(n):
    coins.append(int(input()))
dp = [10001] * (m + 1)
dp[0] = 0

for coin in coins:
    for j in range(coin, m + 1):
        if dp[j - coin] is not 10001:
            dp[j] = min(dp[j], dp[j - coin] + 1)

if dp[m] == 10001:
    print(-1)
else:
    print(dp[m])
