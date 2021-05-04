from collections import Counter
def solution(clothes):
    items = dict()
    types = list()
    for cloth in clothes:
        if cloth[1] not in items.keys():
            items[cloth[1]] = [cloth[0]]
            types.append(cloth[1])
        else:
            items[cloth[1]].append(cloth[0])

    # cnt = Counter([kind for name, kind in clothes])
    # print(cnt)
    # Counter class는 딕셔너리 확장 개념으로 리스트에 있는 key 별 value들의 갯수를 카운트한다.

    answer = 1

    for type in types:
        answer *= len(items[type]) + 1

    return answer - 1


clothes = [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]
print(solution(clothes))
