# 사실 파이썬은 heap구조를 라이브러리 형태로 지원한다.
# heapq ... heappush(),heappop(), heapify() 를 쓰면 된다
# heap 구조의 경우 시간 복잡도는 O(nlogn) 이다.

# 1 heapify를 진행할때 완전이진트리의 높이만큼만 계산이 이뤄지기 때문에 최대 log n 만큼 걸린다.
# (다만, 실제론 1/2 정도만 탐색하게 되기 때문에 1/2 log n 만큼 걸린다 O(1/2 log n) => O(log n) ~> 이러한 특성으로 인해 퀵, 머지 소트 보다 정렬 속도가 빠른경우가 많다.
# n개의 노드를 가지고 있을 때, 각각의 노드가 1번씩 heapify가 이뤄지게 된다.
# 따라서 O(n log n)이 된다.

heap = [7, 6, 5, 8, 3, 5, 9, 1, 6]
num = 9


# 전체에 대한 heapify
# if문에서 root가 작은 경우 바꾸면 .. max heap
# root가 큰 경우로 바꾸면 ... min heap -> 다만 이런 경우 다음 for 문에서 heapify할때 대소 바꿔줘야 한다.

# max-heap을 만드는 과정으로 root를 제외한 나머지 노드에 대해 root와 비교하여 max heap을 만든다.
# swap은 상향식으로 이뤄진다.
for i in range(1, num):
    c = i
    while True:
        root = (c - 1) // 2
        if heap[root] < heap[c]:
            heap[root], heap[c] = heap[c], heap[root]
        c = root
        if c is 0:
            break

print(heap)
# root와 맨 끝 노드와 swap한 후, 맨 끝을 제외한 나머지에 대한 heapify 반복.
for i in range(num - 1, -1, -1):
    heap[0], heap[i] = heap[i], heap[0]
    root = 0
    c = 1

    while True:
        c = 2 * root + 1
        if c < i - 1 and heap[c] < heap[c + 1]:
            c += 1
        if c < i and heap[root] < heap[c]:
            heap[root], heap[c] = heap[c], heap[root]
        root = c

        if not c < i: break
print(heap)
