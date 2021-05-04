# 모범답안..
def solution(genres, plays):
    answer = []
    # 장르별 딕셔너리 key 생성..
    d = {e: [] for e in set(genres)}

    # zip() : 동일한 개수로 이뤄진 자료형을 묶어주는 역할을 한다.

    # 장르, 플레이 횟수, 고유번호
    for e in zip(genres, plays, range(len(plays))):
        d[e[0]].append([e[1], e[2]])

    genreSort = sorted(list(d.keys()), key=lambda x: sum(map(lambda y: y[0], d[x])), reverse=True)
    # x는 장르들을 의미하고, y는 d[x]([ [플레이 횟수, 고유번호] ])를 의미한다.
    # map(condition, list)은 list의 원소들을 condition대로 변환해주는 역할을 한다.

    for g in genreSort:
        # 각 장르별로 플레이 많은 음악순으로 정렬하여 해당 음악의 고유번호를 가져옴
        temp = [e[1] for e in sorted(d[g], key=lambda x: (x[0], -x[1]), reverse=True)]

        # min()에서 temp의 길이가 2보다 작으면 작은게 나옴(결국 1개라는 소리지)
        answer += temp[:min(len(temp), 2)]

    return answer


genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]
print(solution(genres, plays))
