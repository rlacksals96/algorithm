def solution(skill, skill_trees):
    answer = 0
    for st in skill_trees:
        skill_idx = 0
        flag = True
        for i in range(len(st)):
            index=skill.find(st[i]) # 현재 사용하고자 하는스킬이 선행스킬 목록에 존재하는지, 있다면 언제 처음 등장하는지 구함.
            if index != -1:  # 선행스킬 목록에 존재하는 경우
                if skill_idx > index:
                    continue
                elif skill_idx == index:  # 처음 스킬 썼고, 다음 단계로 넘어갈수 있음
                    skill_idx += 1
                    continue
                else:
                    flag = False
                    break
        if flag:
            answer += 1
    return answer


skill = "CBD"
skill_trees = ["BACDE", "CBADF", "AECB", "BDA"]
print(solution(skill, skill_trees))
