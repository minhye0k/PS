#include <iostream>
#include <cstring>
#include <string>

using namespace std;

int answer = 0;
int N, M, K;
int dp[100][100][80];
char alphabet[100][100];
string word;
int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};

int dfs(int x, int y, int depth) {

    int &ret = dp[x][y][depth];

    if(ret != -1) return ret;
    if(depth == word.size()) {
        return 1;
    }

    ret = 0;

    for(int i=0; i<4; i++){
        for(int j=1; j<=K; j++){
            int nx = x + dx[i] * j;
            int ny = y + dy[i] * j;

            if(nx < 0 || nx >= N || ny < 0 || ny >=M) continue;

            if(alphabet[nx][ny] == word[depth]){
                ret += dfs(nx,ny,depth+1);
            }
        }
    }

    return ret;



    
}

int main() {

    cin >> N >> M >> K;
    
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            cin >> alphabet[i][j];
        }
    }

    cin >> word;

    memset(dp, -1, sizeof(dp));

    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            if(word[0] == alphabet[i][j]){
                answer += dfs(i, j, 1);
            }
        }
    }

    cout << answer;
}