#include <iostream>

using namespace std;

int W[10][10];
bool visited[10];
int N;
int ans = 10000001;


void dfs(int cnt, int sum, int cur){
    if(cnt == N){
        if(!W[cur][0]){
            return;
        }
        if(sum + W[cur][0] < ans){
            ans = sum + W[cur][0];
            return;
        }
    }

    for(int i=1; i<N; i++){
        if(visited[i] || !W[cur][i]){
            continue;
        }

        if(sum + W[cur][i] >= ans){
            continue;
        }

        visited[i] = true;
        dfs(cnt+1, sum + W[cur][i], i);
        visited[i] = false;
    }
}

int main() {
    cin >> N;

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin >> W[i][j];
        }
    }
    dfs(1, 0, 0);
    cout << ans;


    
    
}