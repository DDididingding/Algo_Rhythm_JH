from collections import deque

N, K = map(int, input().split(" "))

dq = deque([])
result = []

for i in range(N) :
    dq.append(i+1)
    
    
while len(dq) != 0 :
    for j in range(K-1):
        dq.append(dq.popleft())
        
    result.append(str(dq.popleft()))
    


print('<{}>'.format(", ".join(result)))