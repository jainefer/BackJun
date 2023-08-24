import sys
from collections import deque

def BFS(graph,startNode,targetNode):

    currentNodes=startNode
    count=0
    visited=set()
    graph.append([currentNodes])
    while graph:
        currentNodes=graph.popleft()
        nextLevels=[]
        for currentNode in currentNodes:
            nextNodes=[currentNode-1,currentNode+1,currentNode*2]
            for nextNode in nextNodes:
                if 0<=nextNode<=100000 and nextNode not in visited:
                    if nextNode == targetNode:
                        return count+1
                    nextLevels.append(nextNode)
                    visited.add(nextNode)
               
        graph.append(nextLevels)
        count+=1


n,k=map(int,sys.stdin.readline().rstrip().split())
#시간 절약및 메모리 절약 용
if n<0 or n>100000 or k<0 or k>100000:
    exit()

graph=deque()


if n==k:
    print(0)
else:
    print(BFS(graph,n,k))

        