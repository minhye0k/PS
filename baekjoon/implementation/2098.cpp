#include <iostream>
#include <algorithm>

using namespace std;

int W[16][16];
int dp[16][1 << 16];

int N;
int END;

#define MAX 16000001

int dfs(int cur, int visited){
    if(visited == END){
        if(!W[cur][0]){
            return MAX;
        }
        return W[cur][0];
    }

    int &ret = dp[cur][visited];

    if(ret) return ret;

    ret = MAX;

    for(int i=0; i<N; i++){
        if(!W[cur][i] || (visited & (1 << i))) continue;

        ret = min(ret, W[cur][i] + dfs(i, visited | (1 << i)));
    }

    return ret;
}

int main(){   
    cin >> N;

    END = (1 << N) - 1;

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin >> W[i][j];
        }
    }

    cout << dfs(0,1);


}