import sys

strick = [0] * 5
result = [0] * 5

n = int(sys.stdin.readline())

for i in range(n) :
    a,b = map(int, sys.stdin.readline().split(" "))
    a = a-1
    b = b-1
    for j in range(5) :
        if(j == a or j == b):
            #스트릭의 숫자에 +1
            strick[j]+=1
            #result배열에 지금까지 최대 스트릭 갯수 기록
            if(result[j]<strick[j]):
                result[j] = strick[j]
        else : 
            #result배열에 지금까지 최대 스트릭 갯수 기록
            if(result[j]<strick[j]):
                result[j] = strick[j]
            #스트릭 초기화
            strick[j] = 0

max = 0
grade = 0
for i in range(5):
    if(result[i] > max):
        max = result[i]
        grade = i

print(max, grade + 1)