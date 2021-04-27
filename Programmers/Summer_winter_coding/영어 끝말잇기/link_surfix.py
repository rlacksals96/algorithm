def solution(n, words):
    idx = 1
    turn = 1
    spoken = list()
    prev_char = None
    for word in words:
        if prev_char is None: # 시작의 경우 끝말이 없으므로..
            prev_char = word[0]

        if prev_char == word[0]:
            if word not in spoken:
                spoken.append(word)
            else: # 이미 말한경우
                return [idx, turn]
        else:  # 끝말이 틀린경우
            return [idx, turn]
        # 진행후
        if idx == n:
            idx = 1
            turn += 1
        else:
            idx += 1
        prev_char=word[-1]
    else:
        return [0, 0]


n = 2
# words = ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]
# words=["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]
words = ["hello", "one", "even", "never", "now", "world", "draw"]
print(solution(n, words))
