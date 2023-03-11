#include <iostream>
#include <queue>

using namespace std;

int N, M;
int checked[101][101];
int arr[101][101];

int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};

void bfs(){
    queue<pair<int, int> > q;
    q.push(make_pair(1,1));

    checked[1][1] = 1;

    while(!q.empty()) {
        pair<int, int> p = q.front();
        q.pop();

        int x = p.second;
        int y = p.first;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 1 || nx > M || ny < 1 || ny > N){
                continue;
            }

            if(!checked[ny][nx] && arr[ny][nx] == 1){

                checked[ny][nx] = 1;
                arr[ny][nx] = arr[y][x] + 1;
                q.push(make_pair(ny,nx));
            }
        }
    }
}


int main() {
    cin >> N >> M;

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            scanf("%1d", &arr[i][j]);
        }
    }

    bfs();

    cout << arr[N][M];

    
}