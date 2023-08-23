import sys

num= list(map(int,sys.stdin.readline().rstrip().split()))
dp = [list(map(int, sys.stdin.readline().rstrip().split())) for i in range(num[0])]
value=[[0]*(num[0]+1) for i in range(num[1]+1)]
for i in range(1,num[0]+1):
    for j in range(1,num[1]+1):
        
        if dp[i-1][0]>j:#만약 짐 자체가 무게를 초과했을 경우는 전단계
                value[j][i] =value[j][i-1]
        else:
            value[j][i]=max(value[j-dp[i-1][0]][i-1]+dp[i-1][1],value[j][i-1]) ##j-dp[i-1][0] 은 현재 할당된 무게- 현재 넣을 짐 무게, 따라서 value[j-wi][i-1]로 봐도 된다

print(value[num[1]][num[0]])