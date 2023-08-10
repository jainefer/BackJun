import sys
#값 대입
num= int(sys.stdin.readline())

house=[[0]*3]*num

for i in range(num):
    house[i] = list(map(int,sys.stdin.readline().rstrip().split()))
#자기 전단계의 값중에서 최솟값과 자신의 코스트 값을 더함 
for i in range(1,num):
    house[i][0]=min(house[i-1][1],house[i-1][2])+house[i][0]
    house[i][1]=min(house[i-1][0],house[i-1][2])+house[i][1]
    house[i][2]=min(house[i-1][0],house[i-1][1])+house[i][2]
   


print(min(house[num-1]))








#print(dp)
#dp[0]일때
# min_index=dp[0].index(min(dp[0]))
# min_value=dp[0][min_index]
# if num>=3: 
#     if (min_value>int(dp[1][min_index]) and int(dp[1][min_index])< int(dp[2][min_index])):
#                 temp=dp[i].copy()
#                 temp.sort
#                 min_index=dp[i].index(temp[1])
#                 min_value=dp[i][min_index]
                
# else :
#     min_index=dp[0].index(min(dp[0]))
#     min_value=dp[0][min_index]
# cost+=min_value
# prev_index=min_index
# #dp[1] 이상일때 
# for i in range(1,num):
#     min_index=dp[i].index(min(dp[i]))
#     #print(dp[i])
#     min_value=dp[i][min_index]
#     if i <= num-3:
#         if (min_value>int(dp[i+1][min_index]) and int(dp[i+1][min_index])< int(dp[i+2][min_index])):
#                 temp=dp[i].copy()
#                 temp.sort()
#                 min_index=dp[i].index(temp[1])
#                # print(dp[i])
#                # print(prev_index,min_index)
#                 min_value=dp[i][min_index]
#                 if prev_index==min_index or min_value>dp[i+1][min_index]:
#                     min_index=dp[i].index(max(dp[i]))
#                     min_value=dp[i][min_index]
#     elif i <= num-2: 
#         if min_value>dp[i+1][min_index] or prev_index==min_index:
#             temp=dp[i].copy()
#             temp.sort()
#             min_index=dp[i].index(temp[1])
#             min_value=dp[i][min_index]
#             if prev_index==min_index or min_value>dp[i+1][min_index]:
#                 min_index=dp[i].index(max(dp[i]))
#                 min_value=dp[i][min_index]
#     elif i <= num-1:
#         min_index=dp[i].index(min(dp[i]))
#         min_value=dp[i][min_index]
#         if prev_index==min_index:
#                 min_index=dp[i].index(max(dp[i]))
#                 min_value=dp[i][min_index]
    
#     cost+=min_value
#     prev_index=min_index
#     #print(min_index)
#     #print(dp[i][min_index],cost)
    
    

# print(cost)

