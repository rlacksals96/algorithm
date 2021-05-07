def check_print_list(priorities,candi):
    for p in priorities:
        if p>candi:
            return False
    return True

def solution(priorities, location):
    answer = 0
    while True:
        candi=priorities.pop(0)
        if check_print_list(priorities,candi): # 해당 문건 출력
            if location==0:
                answer+=1
                break
            answer += 1

        else:
            priorities.append(candi)

        location -= 1
        if location == -1:
            location = len(priorities) - 1
    return answer



priorites=[1, 1, 9, 1, 1, 1]
location=0
print(solution(priorites,location))