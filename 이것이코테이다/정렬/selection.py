# 여기서 말하는 선택은... '매번 가장 작은 것을 선택'을 의미한다.
# 시간복잡도 n + n-1 + n-2 + ... + 2 +1 -> O(n^2+n / 2) ~= O(n^2)
import time
arr=[3,7,5,9,0,3,1,6,2,4,8]


for i in range(len(arr)):
    min_idx=i
    for j in range(i+1,len(arr)):
        if arr[min_idx]>arr[j]:
            min_idx=j
    arr[min_idx],arr[i]=arr[i],arr[min_idx]
t2=time.time()
print(arr)
