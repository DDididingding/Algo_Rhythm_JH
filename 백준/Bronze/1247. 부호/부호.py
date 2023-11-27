import sys
for j in range(3):
    N = int(sys.stdin.readline())
    X = int()
    S = 0

    for i in range(N):
        X = int(sys.stdin.readline())
        S = X + S

    if S == 0:
        print(0)
    elif S > 0:
        print("+")
    elif S < 0:
        print("-")