import sys
from collections import deque

def BFS(graph,startNode,targetNode):

    currentNodes=startNode
    count=0
    visited=set() #중복검사 용 집합
    graph.append([currentNodes])
    while graph:
        #현재 노드에 탐색할 값 할당(해당 층)
        currentNodes=graph.popleft()
        nextLevels=[]
        #현재 노드에서 다음 노드를 할당 함
        for currentNode in currentNodes:
            nextNodes=[currentNode-1,currentNode+1,currentNode*2]
            for nextNode in nextNodes:
                #해당 노드가 조건에 맞는지 또 중복은 아닌지 검사하면서, 타겟노드 찾음
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

        