#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, K;

    cin >> N >> K;

    vector<int> v;

    for(int i=0; i<N; i++) {
        int n;
        cin >> n;
        v.push_back(n);
    }

    int answer = 0;

    int i = N-1;
    while(i>=0){
        if(K == 0){
            cout << answer;
            return 0;
        }

        if(K >= v[i]){
            K -= v[i];
            answer++;
        }else{
            i--;
        }
    }
}