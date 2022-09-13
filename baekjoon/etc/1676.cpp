#include <iostream>

using namespace std;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);


    int N;

    cin >> N;
    
    int answer = 0;

    for(int i=5; i<=N; i*=5){
        answer += N/i;
    }

    cout << answer;
}