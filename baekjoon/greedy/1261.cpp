#include <bits/stdc++.h>

using namespace std;

int N,M;
int board[100][100];
int dist[100][100];

int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};

int answer = 10000;

void bfs(){
    queue<pair<int, int>> q;
    q.push({0, 0});
    dist[0][0] = 0;
    
    while(!q.empty()){
        pair<int, int> p = q.front();
        q.pop();

        int x = p.first;
        int y = p.second;


        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx >= N || ny <0 || ny >=M) continue;

            if(board[x][y] == 1){
                if(dist[nx][ny] > dist[x][y] + 1){
                    dist[nx][ny] = dist[x][y] + 1;
                    q.push({nx, ny});
                }
            }else{
                if(dist[nx][ny] > dist[x][y]){
                    dist[nx][ny] = dist[x][y];
                    q.push({nx, ny});
                }
            }
        }
    }
}


int main(){
    cin >> M >> N;

    memset(dist, 10000, sizeof(dist));

    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            scanf("%1d", &board[i][j]);
        }
    }

    bfs();

    cout << dist[N-1][M-1];
}