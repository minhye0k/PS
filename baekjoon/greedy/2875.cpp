#include <bits/stdc++.h>

using namespace std;

int main() {
    int N, M, K;
    cin >> N >> M >> K;

    int answer = 0;

    while(true){
        if(N >= 2 && M >=1){
            N-=2;
            M-=1;
            if(N+M < K) break;
            answer++;
        }else{
            break;
        }
        
    }

    cout << answer;
}