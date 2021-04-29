#해결중..
def open_station(apartments, num, w):
    for i in range(num - w, num + w + 1):
        if i < 1 or i > len(apartments) - 1:
            continue
        apartments[i] = True


def solution(n, stations, w):
    answer = 0
    apartments = [False for _ in range(n + 1)]
    apartments[0] = True
    for s in stations:
        open_station(apartments, s, w)
    # print(apartments)

    cnt=0
    flag=True
    for i in range(1,len(apartments)):
        if apartments[i]==False:
            flag=False
            cnt+=1
        if flag==False and cnt==2*w:
            open_station(apartments,i-w,w)
            flag=True
            cnt=0
            answer+=1
        elif flag==True and cnt==2*w:
            cnt=0


    return answer


N = 16
stations = [9]
W = 2

print(solution(N, stations, W))
