def bin_search(arr, m, start, end):
    result = 0
    while start <= end:
        mid = (start + end) // 2
        total = 0
        for x in arr:
            if x > mid:
                total += x - mid
        if total < m:
            end = mid - 1
        else:
            result = mid
            start = mid + 1
    return result

n,m=list(map(int,input().split(' ')))
arr=list(map(int,input().split()))
print(bin_search(arr,m,0,max(arr)))