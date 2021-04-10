##문제 해결중....

import sys

input=lambda :sys.stdin.readline().rstrip()

n=int(input())
alphabet=dict()
num=[i for i in range(10)]
len_list=[]
words=[]
real_words=copy.deepcopy(words)

for _ in range(n):
    tmp=input()
    words.append(tmp)
    len_list.append(len(tmp))

words.sort(key=lambda x:len(x),reverse=True)
len_list.sort(reverse=True)

alphabet.setdefault('D')
alphabet.setdefault('B')
alphabet.setdefault('A')
alphabet.setdefault('C')
alphabet.setdefault('D')
print(alphabet)