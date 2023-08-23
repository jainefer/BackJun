import sys

length= int(sys.stdin.readline())

dp=[0]*(length+1)
dp[0]=1
dp[1]=3
if dp[length-1]==0: #이미 기억한 값이 있을경우는 건너뛰고 바로 알려준다
    for i in range(2,length):
        dp[i]=dp[i-1]+2*dp[i-2] #점화식
print(dp[length-1]%10007)