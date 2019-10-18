[問題文]:https://atcoder.jp/contests/abc140/tasks/abc140_b

まず、A1 種類目の料理を食べるので、BA1 の満足度を得ます。
次に、A2 種類目の料理を食べるので、BA2 の満足度と、A2 = A1 + 1 ならば CA1 の満足度を得ます。i (2 ≤ i ≤ N) 番目には Ai 種類目の料理を食べるの
で、BAi の満足度と Ai = Ai−1 + 1 ならば CAi−1 の満足度を得ます。
```
n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))

ans=0

#x,yにリストaをZIP関数で入れる
for x,y in zip(a,a[1:]):
  if y == x+1:
    ans += c[x-1]
    
print(sum(b)+ans)
```
