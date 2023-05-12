#include <bits/stdc++.h>

using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    int A[N];

    for(int i=0; i<N; i++) {
        cin >> A[i];
    }

    int cnt = 0;

    int start = 0, end = 0;
    int sum = 0;

    while(start <= N){
        if(sum >= M) sum -= A[start++];
        else sum += A[end++];
        
        if(sum == M) cnt++;
    }


    cout << cnt;


}