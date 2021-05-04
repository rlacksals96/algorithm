def solution(genres, plays):
    answer = []
    myDic = dict()
    for i in range(len(genres)):
        if genres[i] not in myDic:
            myDic[genres[i]] = [[i, plays[i]]]
        else:
            myDic[genres[i]].append([i, plays[i]])

    # 딕셔너리 value를 플레이수 많은 순으로 재정렬해주고, 장르별로 총 플레이수 나타낸 리스트 만들기.
    genres = set(genres)
    cnt_list = []
    for g in genres:
        tmp = myDic[g]
        tmp.sort(key=lambda x: (-x[1]))
        cnt = 0
        for n, p in tmp:
            cnt += p
        cnt_list.append([g, cnt])
    cnt_list.sort(key=lambda x: (-x[1]))

    for g, n in cnt_list:
        tmp = myDic[g]
        if len(tmp) == 1:
            answer.append(tmp[0][0])
        else:
            answer.append(tmp[0][0])
            answer.append(tmp[1][0])

    return answer


genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]
print(solution(genres, plays))
