import sys

input = lambda: sys.stdin.readline().rstrip()


def update_pos(length, m):
    if m == 0:
        return length - 1
    else:
        return m - 1


def find_docs(docs, m):
    cnt = 0
    while True:
        # 원하는 문서 출력 함.
        if m == 0 and max(docs) == docs[m]:
            return cnt + 1

        # 원하는 문서가 아닌 다른 문서가 출력되는 경우
        elif docs[0] == max(docs) and m != 0:
            docs.pop(0)
            m = update_pos(len(docs), m)
            cnt += 1
        # 현재 문서의 우선순위가 최고가 아니라서 밀리는 경우
        elif docs[0] < max(docs):
            tmp = docs.pop(0)
            docs.append(tmp)
            m = update_pos(len(docs), m)


T = int(input())
for _ in range(T):
    n, m = map(int, input().split())
    docs = list(map(int, input().split()))
    result = find_docs(docs, m)
    print(result)
