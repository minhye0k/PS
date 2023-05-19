#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, M;

    cin >> N >> M;

    int answer = 0;
    if(N < 2) answer = 1;
    else if(N == 2) answer = min((M+1)/2, 4);
    else{
        if(M<7) answer = min(M ,4);
        else answer = M -2;
    }

    cout << answer;

}