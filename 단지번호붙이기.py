import sys
from collections import deque

result= []
count=0
dirX=[0,0,-1,1]
dirY=[-1,1,0,0]

def DFS(graph,i,j,count):
    #종료조건
    if i < 0 or i >= num or j < 0 or j >= num or graph[i][j] != 1:
        return count
    #방문한 곳은 모두 0처리를 하는 동시에 count를 센다
    graph[i][j] = 0
    count = count + 1
    for k in range(4):
        count= DFS(graph, i + dirX[k], j + dirY[k], count)
        
    return count

num=int(sys.stdin.readline())

graph=[]
for i in range(num):
    graph.append(list(map(int, input())))
for i in range(num):
    for j in range(num):
        if graph[i][j]==1:
            count=0
            count=DFS(graph,i,j,count)
            result.append(count)

result.sort()
print(len(result))
for i in result:
    print(i)