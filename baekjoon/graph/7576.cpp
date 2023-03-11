#include <iostream>
#include <queue>


using namespace std;

int tomato[1001][1001];
int checked[1001][1001];

int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};

queue<pair<int, int> > q;
int M, N;


void bfs(){
    while(!q.empty()){
        int size = q.size();

        pair<int, int> p = q.front();
        q.pop();
        
        for(int i=0; i<4; i++){
            int nx = p.second + dx[i];
            int ny = p.first + dy[i];

            if(nx > M || nx < 1 || ny <1 || ny > N){
                continue;
            }

            if(!checked[ny][nx]&& tomato[ny][nx] == 0){
                checked[ny][nx] = 1;
                tomato[ny][nx] = tomato[p.first][p.second] + 1;
                q.push(make_pair(ny,nx));
            }
        }

    }
}

int main() {
    cin >> M >> N;

    for(int i=1; i<=N; i++){
        for(int j=1; j<=M; j++){
            cin >> tomato[i][j];

            if(tomato[i][j] == 1){
                q.push(make_pair(i,j));
                checked[i][j] = 1;
            }
        }
    }

    bfs();

    int max = 0;

    for(int i=1; i<=N; i++){
        for(int j=1; j<=M; j++){
            if(tomato[i][j] == 0){
                cout << -1;
                return 0;
            }

            if(tomato[i][j] > max){
                max = tomato[i][j];
            }
        }
    }

    if(max == 1){
        cout << 0;
        return 0;
    }

    cout << max - 1;

    return 0;
}