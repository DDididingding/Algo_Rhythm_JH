sol = [999999999, 0] #time, height



#필드 입력받기
field = []

y, x, inventory = map(int, input().split(" "))

for i in range(y):
    row = list(map(int, input().split(" ")))
    field.append(row)
    

#최솟값, 최댓값 찾기

minHeight = 300
maxHeight = 0

for i in range(y):
    for j in range(x):
        if(field[i][j] < minHeight):
            minHeight = field[i][j]
        
        if(field[i][j] > maxHeight):
            maxHeight = field[i][j]

#최소값부터 1씩 증가시키며 체크

currHeight = minHeight

while currHeight <= maxHeight:
    
    sumOver = 0
    sumBelow = 0
    workingTime = 0
        
    #기준 높이와의 차이를 계산
    for i in range(y):
        for j in range(x):
            diff = field[i][j] - currHeight
        
            if diff > 0 :
                sumOver += diff
            if diff < 0 :
                sumBelow += diff
    
    #print(f'sumOver = {sumOver}, inventory = {inventory}, sumBelow = {sumBelow}')
    #가지고 있는 블럭 + 파낸 블럭으로 구멍을 메울 수 있는지 체크
    #이후 현재 높이로 맞추는 시간 계산
    if sumOver + inventory >= -sumBelow :
        workingTime = sumOver * 2 - sumBelow
        #최소 시간이라면 그때 시간과 높이 저장
        if workingTime <= sol[0]:
            sol[0] = workingTime
            sol[1] = currHeight
    
    #메울 수 없으면 아무것도 실행하지 않음
    
    #현재 높이 1 증가
    currHeight += 1
    
print(*sol)