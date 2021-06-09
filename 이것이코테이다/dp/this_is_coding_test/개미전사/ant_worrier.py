n=int(input())
storage=list(map(int,input().rstrip().split()))
dp=[0]*len(storage)
dp[0]=storage[0]
dp[1]=max(storage[0],storage[1])

for i in range(2,len(storage)):
    dp[i]=max(dp[i-1],dp[i-2]+storage[i])
print(dp[-1])