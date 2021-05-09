def solution(answers):
    q_len = len(answers)

    types = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    ans_sheet = []

    tmp = []
    for i in range(q_len):
        i %= 5
        tmp.append(types[0][i])
    ans_sheet.append(tmp)

    tmp = []
    for i in range(q_len):
        i %= 8
        tmp.append(types[1][i])
    ans_sheet.append(tmp)

    tmp = []
    for i in range(q_len):
        i %= 10
        tmp.append(types[2][i])
    ans_sheet.append(tmp)

    # print(ans_sheet)
    result = [0 for _ in range(3)]

    for i in range(len(answers)):
        for j in range(3):
            if ans_sheet[j][i] == answers[i]:
                result[j] += 1

    max_score = max(result)
    answer = []
    for i in range(3):
        if result[i] == max_score:
            answer.append(i + 1)

    return answer


answers = [5, 5, 5, 1, 4, 1]
print(solution(answers))
