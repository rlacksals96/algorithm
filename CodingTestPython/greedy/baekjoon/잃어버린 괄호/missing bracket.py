import sys

input = lambda: sys.stdin.readline().rstrip()

formula = input()
arr = [0 for _ in range(25)]

sum = 0
tmp = 0
j = 0
for f in formula:
    if f == '-':
        sum += tmp
        arr[j] = sum
        j += 1
        sum = 0
        tmp = 0
    elif f == '+':
        sum += tmp
        tmp = 0
    else:
        tmp *= 10
        tmp += int(f)

sum += tmp
arr[j] = sum

result = arr[0]
for i in range(1, 25):
    result -= arr[i]
print(result)
