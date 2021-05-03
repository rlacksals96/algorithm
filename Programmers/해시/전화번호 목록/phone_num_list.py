def solution(phone_book):
    answer=True
    hash_map={}
    for phone_num in phone_book:
        hash_map[phone_num]=1
    for phone_num in phone_book:
        tmp=""
        for num in phone_num:
            tmp+=num
            if tmp in hash_map and tmp!=phone_num:
                answer=False
    return answer



print(solution(["12","123","1235","567","88"]))