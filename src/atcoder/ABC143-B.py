[URL]:https://atcoder.jp/contests/abc143/tasks/abc143_b
全探索

```
N=int(input())
D=list(map(int,input().split()))
ans=0

#2重for文で要素Dから1つずつ取り出す
for i in range(N):
  for j in range(i+1,N):
    ans += D[i] * D[j]
    
print(ans)
```
