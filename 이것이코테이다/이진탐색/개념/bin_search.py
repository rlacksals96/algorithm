import sys


def binary_search_recursive(arr, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    if arr[mid] == target:
        return mid
    elif arr[mid] > target:
        return binary_search_recursive(arr, target, start, mid - 1)
    else:
        return binary_search_recursive(arr, target, mid + 1, end)


def binary_search_repeat(arr, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None


n, target = list(map(int, sys.stdin.readline().rstrip()))
array = list(map(int,  sys.stdin.readline().rstrip()))
# rstrip: 마지막에 자동으로 들어가는 엔터 제거 가능
# sys를 호출하는 경우는 사실 입력이 1000만개를 넘어가거나 탐색 범위가 1000억 이상인 경우라 대부분은 쓸일이 없긴함.
result = binary_search_recursive(array, target, 0, n - 1)
result2 = binary_search_repeat(array, target, 0, n - 1)
if result is None:
    print("no result")
else:
    print(result + 1)

if result2 is None:
    print("no result")
else:
    print(result2 + 1)

# test input & result

# 10 7
# 1 3 5 7 9 11 13 15 17 19
# ans: 4
#
#
# 10 7
# 1 3 5 6 9 11 13 15 17 19
# ans: no result
