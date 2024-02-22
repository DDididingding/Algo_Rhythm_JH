a = input()

piece = 0
total = 0

for i in range(len(a)):
    if a[i] == "(":
        piece += 1
    else :
        if a[i-1] == "(" : 
            piece -= 1
            total += piece
        else :
            total += 1
            piece -= 1


print(total)