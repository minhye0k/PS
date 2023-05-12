#include <bits/stdc++.h>

using namespace std;

int main(){
    int N, S;
    cin >> N >> S;

    int arr[N];

    for(int i=0; i<N; i++){
        cin >> arr[i];
    }

    int answer = 100000;
    int start = 0, end = 0;

    int sum = 0;

    while(start < N){
        if(sum >= S){
            int length = end - start;
            answer = min(answer, length);
            sum -= arr[start++];
        }else if (end == N) break;
        else sum += arr[end++];
    }
    if(answer == 100000){
        cout << "0";
        return 0;
    }
    cout << answer;
    return 0;
}