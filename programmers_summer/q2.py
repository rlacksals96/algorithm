

def solution(t, r):
    answer = []

    ids=[i for i in range(len(t))]
    # id,lift_num,rank(smaller better)
    persons=[]
    for i in range(len(ids)):
        persons.append([ids[i],t[i],r[i]])
    # persons=list(zip(ids,t,r))
    while persons:
        persons.sort(key=lambda x: (x[1], x[2], x[0]))
        print(persons)
        person=persons.pop(0)
        answer.append(person[0])
        for p in persons:
            if p[1]==person[1]:
                p[1]+=1




    return answer



t=[7,6,8,1]
r=[0,1,2,3]
print(solution(t,r))