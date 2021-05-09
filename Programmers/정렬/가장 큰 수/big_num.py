def solution(numbers):
    numbers=list(map(str,numbers))
    #길이 맞추기 위함임.
    numbers.sort(key=lambda x:x*3,reverse=True)

# 모든 값이 0인 경우를 제외하면 수들 연결해서 출력
# 모두 0이면 결과가 0인데 리턴형이 문자열이므로 '0' 리턴
    answer=''.join(numbers)
    for i in numbers:
        if i!='0':
            return answer
    return '0'

numbers=[0,0,0,0]
print(solution(numbers))