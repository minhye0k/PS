#include <iostream>
#include <math.h>
#include <algorithm>

using namespace std;

bool visited[8];
int arr[8];
int ans;
int N;

void dfs(int num, int cnt, int sum){
    if(cnt == N) {
        ans = max(ans, sum);
    }

    for(int i=0; i<N; i++) {
        if(!visited[i]) {
            visited[i] = true;
            dfs(i, cnt + 1, sum + abs(arr[i] - arr[num]));
            visited[i] = false;
        }
    }
}

int main(){

    cin >> N;

    for(int i=0; i<N; i++){
        cin >> arr[i];
    }

    for(int i=0; i<N; i++) {
        if(!visited[i]) {
            visited[i] = true;
            dfs(i, 1, 0);
            visited[i] = false;
        }
    }

    cout << ans;

    
}