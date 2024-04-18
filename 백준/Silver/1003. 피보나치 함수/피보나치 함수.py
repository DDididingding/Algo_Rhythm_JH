import sys


oz = [[1, 0],[0, 1]]

def fibo(x):
    if x < len(oz):
        return oz[x]
    else:
        while len(oz) <= x:
            a = oz[-1]
            b = oz[-2]
 
            new_result = [a[0] + b[0], a[1] + b[1]]

            oz.append(new_result)
        return oz[x]

T = int(sys.stdin.readline())

for i in range(T):
    N = int(sys.stdin.readline())
    print(*fibo(N))