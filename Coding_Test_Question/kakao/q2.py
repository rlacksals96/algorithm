#solve
from itertools import combinations
def solution(places):
    answer = []


    for place in places:
        persons = []
        for i in range(5):
            for j in range(5):
                if place[i][j]=='P':
                    persons.append((i,j))
        # print(persons)
        cases=list(combinations(persons,2))


        #거리두기 실패..실패케이스 리턴되는 경우
        fail_cases=safeDistance(cases)
        # print(fail_cases)
        # 거리가 1이라서 계산할 필요가 없는 경우.
        if fail_cases==-1:
            answer.append(0)
            continue
        if fail_cases:

            # 파티션 방어 성공.
            if checkPartition(place,fail_cases):
                answer.append(1)

            # 파티션도 실패.
            else:
                answer.append(0)
        #거리두기 성공.
        else:
            answer.append(1)
    return answer

def safeDistance(cases):
    fail=[]
    for case in cases:
        if getManhattan(case[0][0], case[0][1], case[1][0], case[1][1]) <= 1:
            return -1
        if getManhattan(case[0][0],case[0][1],case[1][0],case[1][1])<=2:
            fail.append([case[0][0],case[0][1],case[1][0],case[1][1]])

    return fail

def checkPartition(place,fail_cases):
    for fail in fail_cases:
        # 가로로 평행하게 배치
        if fail[1]==fail[3]:
            # 파티션 있는 경우.
            if fail[0]>fail[2]:
                if place[fail[2]+1][fail[1]]=='X':
                    continue
                else:
                    return False
            else:
                if place[fail[2]-1][fail[1]]=='X':
                    continue
                else:
                    return False
        # 세로로 평행하게 배치
        elif fail[0]==fail[2]:
            # 파티션 있는 경우.
            if fail[1]>fail[3]:
                if place[fail[3]+1][fail[2]]=='X':
                    continue
                else:
                    return False
            else:
                if place[fail[3]-1][fail[2]]=='X':
                    continue
                else:
                    return False
        # 대각선으로 배치
        else:
            if place[fail[0]][fail[3]]=='X' and place[fail[2]][fail[1]]=='X':
                continue
            else:
                return False
    return True



def getManhattan(x1,y1,x2,y2):
    return abs(x1-x2)+abs(y1-y2)

places=[["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]
print(solution(places))