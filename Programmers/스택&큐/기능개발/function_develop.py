def solution(progresses, speeds):
    answer = []

    while progresses:
        for i in range(len(progresses)):
            progresses[i]+=speeds[i]

        cnt=0
        while progresses[0]>=100:
            progresses.pop(0)
            speeds.pop(0)
            cnt+=1
            if not progresses:
                break
        if cnt:
            answer.append(cnt)

    return answer


progresses=[95, 90, 99, 99, 80, 99]
speeds=[1, 1, 1, 1, 1, 1]
print(solution(progresses,speeds))