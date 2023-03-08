#include <iostream>
#include <queue>
#include <string.h>

using namespace std;

int matrix[51][51];
int checked[51][51];

int dx[3] = {-1, 0 ,1};
int dy[3] = {-1, 0 ,1};

int w;
int h;

void bfs(int x, int y, int cnt){
    queue<pair<int, int> > q;

    pair<int, int> start = make_pair(x,y);
    checked[y][x] = cnt;

    q.push(start);

    while(!q.empty()){
        pair<int, int> next = q.front();
        q.pop();

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                int nx = next.first + dx[j];
                int ny = next.second + dy[i];

                if (nx < 1 || nx > w || ny < 1 || ny > h) {
                    continue;
                }

                if(!checked[ny][nx] && matrix[ny][nx]) {
                    checked[ny][nx] = cnt;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }

}

int main(){

    while (true) {
        memset(matrix, 0, sizeof(matrix));
        memset(checked, 0, sizeof(checked));

        int cnt = 0;
        cin >> w >> h;

        if (w == 0 && h == 0) {
            return 0;
        }

        for (int i=1; i<=h; i++){
            for (int j=1; j<=w; j++){
                int sign = 0;
                cin >> sign;

                matrix[i][j] = sign;
            }
        }

        for (int i=1; i<=h; i++){
            for (int j=1; j<=w; j++){
                if(!checked[i][j] && matrix[i][j]) {
                    bfs(j, i, ++cnt);
                }
            }
        }

        cout << cnt << endl;
    }
}

