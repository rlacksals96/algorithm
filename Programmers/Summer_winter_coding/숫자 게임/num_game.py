def solution(A, B):
    answer = 0
    A.sort(reverse=True)
    B.sort(reverse=True)

    for i in range(len(A)):
        if B[0] > A[0]:
            answer += 1
            B.pop(0)
        A.pop(0)
    return answer


A = [5, 1, 3, 7]
B = [2, 2, 6, 8]
print(solution(A, B))
