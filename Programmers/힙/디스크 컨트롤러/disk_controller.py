def solution(jobs):
    answer, start, time = 0, 0, 0

    n=len(jobs)

    jobs.sort(key=lambda x: (x[1], x[0]))
    while jobs:
        for i in range(len(jobs)):
            if jobs[i][0] <= start:
                time = time + start + jobs[i][1] - jobs[i][0]
                start = start + jobs[i][1]
                jobs.remove(jobs[i])
                break
            if i == len(jobs) - 1:
                start += 1

    answer = time // n
    return answer


jobs = [[0, 3], [1, 9], [2, 6]]
print(solution(jobs))
