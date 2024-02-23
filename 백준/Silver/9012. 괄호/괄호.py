T = int(input())

for _ in range (T):
    VPS = input()
    stack = []
        
    for i in range(len(VPS)) :
        if VPS[i] == "(":
            stack.append(1)
        elif len(stack) >0:
            stack.pop()
        else:
            stack.append(-1)
            break
            
    if len(stack) == 0 :
        print("YES")
    else :
        print("NO")