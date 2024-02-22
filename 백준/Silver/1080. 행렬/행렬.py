y, x = map(int, input().split(" "))

grid = [list(input()) for _ in range(y)]
target = [list(input()) for _ in range(y)]

count = 0

# 입력받은 좌표로부터 3*3 행렬을 뒤집는다
def flip(y, x) :
    
    for i in range(3):
        for j in range(3):
            if grid[y+i][x+j] == "1" :
                grid[y+i][x+j] = "0"
                
            elif grid[y+i][x+j] == "0":
                grid[y+i][x+j] = "1" 
                
# 완탐하면서 뒤집기
if x>=3 and y>=3:
    for i in range(y-2):
        for j in range(x-2):
            if grid[i][j] != target[i][j]:
                flip(i, j)
                count+=1



# 최종적으로 맞는지 비교
if grid == target :
    print(count)
else:
    print(-1)