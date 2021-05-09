def solution(n, k, cmd):
    answer = ''
    current_list=[i for i in range(n)]
    current_pos=0
    delete_list=[]
    work_flow=[]
    for c in cmd:
        if c[0]=='Z':
            undo()
            continue
        if c[0]=='C':
            current_pos=delete_element(current_list,current_pos,delete_list)
            work_flow.append(['-',current_pos])
            continue

        direction=c[0]
        move=c[2]
        current_pos=update_pos(direction,move,current_pos)
        work_flow.append([direction,move]) # 복구시 pop()

    return answer

# 셀 삭제
def delete_element(current_list,current_pos,delete_list,n):
    # 삭제시 위치 넘어가는 경우.
    if current_pos+1==n:
        delete_list.append(current_list.pop(-1))
        current_pos=len(current_list)-1

    delete_list.append(current_list.pop(current_pos))

    return current_pos




# ctrl z
def undo():
    return 1
# 커서 이동
def update_pos(direction,move,cur_pos):
    if direction=='U':
        for i in range(move):
            cur_pos-=1
    else:
        for i in range(move):
            cur_pos+=1

    return cur_pos


n=8
k=2
cmd=["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]
print(solution(n,k,cmd))