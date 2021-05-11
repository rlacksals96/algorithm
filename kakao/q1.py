#solved
def solution(s):
    answer = 0

    nums = {"zero": 0, "one": 1, "two": 2, "three": 3, "four": 4, "five": 5, "six": 6, "seven": 7, "eight": 8,
            "nine": 9}
    words = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]

    for w in words:
        s=s.replace(w,str(nums[w]))


    return int(s)


s = "123"
print(solution(s))
