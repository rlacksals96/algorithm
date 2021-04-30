import math
def solution(n, stations, w):
    result=0
    distance=[]

    # 기지국 사이..
    for i in range(1,len(stations)):
        distance.append((stations[i]-w-1)-(stations[i-1]+w))

    # 맨 앞 기지국에서 첫번쨰 아파트 사이에 전파가 닿지 않는 거리,
    # 맨 뒤 기지국 ~ 맨 뒤 아파트 사이에 전파 안닿는 거리.
    distance.append(stations[0]-w-1)
    distance.append(n-(stations[-1]+w))

    for i in distance:
        if i<=0:
            continue
        # 2*w +1 -> 양끝 커버리지 + 기지국 있는 구간.
        result+=math.ceil(i/((w*2)+1))
    return result


N = 16
stations = [9]
W = 2

print(solution(N, stations, W))
