import sys

num= int(sys.stdin.readline())
#배열 할당(num의 개수만큼)
p=[0]*(num+1)
#초기값 할당 p[0],p[1]
p[0]=1
p[1]=2
#전 경우의 수, 전전단계의 경우의 수 
if p[num-1] == 0:
    for i in range(2,num):
        p[i]=p[i-1]+p[i-2]

print(p[num-1]%10007)