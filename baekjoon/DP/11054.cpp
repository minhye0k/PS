#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void){
    int N;
    cin >> N;

    vector<int> arr(N+1,0);
    vector<int> dp(N+1,1);
    vector<int> reverseDp(N+1,1);

    int answer = 1;

    for(int i=1; i<=N; i++){
        cin >> arr[i];
    }

    for(int i=1; i<=N; i++){
        for(int j=1; j<i; j++){
            if(arr[i]>arr[j]){
                dp[i] = max(dp[i], dp[j]+1);
            }
        }
    }

    for(int i=N; i>=1; i--){
        for(int j=N; j>i; j--){
            if(arr[i]>arr[j]){
                reverseDp[i] = max(reverseDp[i], reverseDp[j]+1);
            }
        }
    }

    for(int i=1; i<=N; i++){
        int leftMax = 0;
        int rightMax = 0;
        for(int j=1; j<i; j++){
            if(arr[i] > arr[j]){
                leftMax = max(leftMax, dp[j]);
            }
        }
        for(int j=N; j>i; j--){
            if(arr[i]>arr[j]){
                rightMax = max(rightMax, reverseDp[j]);
            }
        }
        answer = max(answer, leftMax + 1 + rightMax);
    }

    cout << answer << '\n';


}