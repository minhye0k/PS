#include <bits/stdc++.h>

using namespace std;

bool visited[1000][1000][2];
int arr[1000][1000];

int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};

int N,M;

struct st{
    int x;
    int y;
    int broken;
    int cnt;
};

int bfs(){
    queue<st> q;

    q.push({0,0,0,1});
    visited[0][0][0] = true;

    while(!q.empty()){
        st s = q.front();
        q.pop();

        int x = s.x;
        int y = s.y;
        int broken = s.broken;
        int cnt = s.cnt;

        if(x==N-1 && y==M-1) return cnt;
        
        bool check = false;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny < 0 || nx >=N || ny >=M || visited[nx][ny][broken]) continue;

            if(!arr[nx][ny]){
                q.push({nx,ny, broken, cnt+1});
                visited[nx][ny][broken] = true;
            }else if(!broken) {
                q.push({nx,ny,1, cnt+1});
                visited[nx][ny][1] = true;
            }
        }
    }

    return -1;
}

int main(){
    cin >> N >> M;

    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            scanf("%1d", &arr[i][j]);
        }
    }

    cout << bfs();

    return 0;
}