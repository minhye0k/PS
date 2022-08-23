#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void){
    int N;
    cin >> N;

    vector<int> d(N+1, 1);
    vector<int> arr(N+1, 0);
    int answer = 1;

    for(int i=1; i<=N; i++){
        cin >> arr[i];
    }
    for(int i=2; i<=N; i++){
        for(int j=1; j<i; j++){
            if(arr[i] > arr[j]){
                d[i] = max(d[i], d[j] + 1);
            }
        }
        answer = max(answer, d[i]);
    }

    cout << answer << '\n';
}