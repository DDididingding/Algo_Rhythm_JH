N = int(input())

users =[]

for _ in range(N):
    user = input().split(" ")
    age = int(user[0])
    name = user[1]
    
    users.append([age, name])


sortedUsers = sorted(users, key = lambda users : users[0])


for i in range(N):
    print('{} {}'.format(sortedUsers[i][0], sortedUsers[i][1]))