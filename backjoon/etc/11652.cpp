#include <iostream>
#include <algorithm>

using namespace std;

int main(void){
    long long arr[100001] = {0};
    long long answer = 0;
    
    int N;
    cin >> N;

    for(int i=0; i<N; i++){
        cin >> arr[i];
    }

    sort(arr, arr+N);

    answer = arr[0];
    int max = 0;
    int cnt = 0;
    for(int i=1; i<N; i++){
        if(arr[i] == arr[i-1]){
            cnt++;
        }else{
            cnt = 0;
        }

        if(cnt>max){
            max = cnt;
            answer = arr[i];
        }
    }
    
    cout << answer;
}