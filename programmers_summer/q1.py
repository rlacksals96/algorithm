#solved
def solution(code, day, data):
    answer = []
    for d in data:
        if code in d and day in d:
            answer.append(get_data(d))
    answer.sort(key=lambda x:x[0])
    answer=[p for d,p in answer]
    for i in range(len(answer)):
        answer[i]=int(answer[i])
    return answer

def get_data(data):
    arr=[]
    time_idx=data.find("time=")
    time_idx+=5
    # print(data[time_idx:time_idx+10])
    code_idx=data.find("code=")
    price_idx=data.find("price=")
    price_idx+=6
    # print(data[price_idx:code_idx])
    arr.append(data[time_idx:time_idx+10])
    arr.append(data[price_idx:code_idx].strip())
    return arr

company_code="012345"
day="20190620"
data=["price=80 code=987654 time=2019062113","price=90 code=012345 time=2019062014","price=120 code=987654 time=2019062010","price=110 code=012345 time=2019062009","price=95 code=012345 time=2019062111"]
print(solution(company_code,day,data))
