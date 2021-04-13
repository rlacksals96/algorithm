n=int(input())
eMin=60
eSec=60

cnt=0
for h in range(n+1):
    for m in range(eMin):
        for s in range(eSec):
            if '3' in str(h)+str(m)+str(s):
                cnt+=1
print(cnt)