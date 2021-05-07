def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = []  # 다리 위에 있는 트럭들 [트럭의 무게,이동거리]
    while truck_weights or bridge:
        # 대기 트럭이 있으면 꺼내고 없으면 그냥 없는거임(0)
        truck = 0
        if truck_weights:
            truck = truck_weights[0]

        if truck + sum(w for w, distance in bridge) <= weight:

            # 대기 트럭이 있으면 꺼내고 없으면 그냥 없는거임(0)
            # 다리에 올라갈 수 있으면 올리기
            if truck_weights:
                bridge.insert(0, [truck_weights.pop(0), 0])
        for t in bridge:
            t[1] += 1

        if bridge[-1][1] == bridge_length:
            bridge.pop()

        # 1턴 지남
        answer += 1

    return answer + 1


bridge_length = 100
weight = 100
truck_weights = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
print(solution(bridge_length, weight, truck_weights))
