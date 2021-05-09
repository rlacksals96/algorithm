#도전중..
def solution(citations):
    citations.sort()
    idx=len(citations)//2

    plus=False
    if citations[idx]<len(citations[idx:]):
        plus=True

    if plus:
        while citations[idx]<len(citations[idx:]):
            idx+=1
    else:
        while citations[idx]>=len(citations[idx:]):
            idx-=1

    return citations[idx]

citations = [3, 0, 6, 1, 5, 4]
print(solution(citations))
