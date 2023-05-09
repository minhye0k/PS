#include <bits/stdc++.h>

using namespace std;

bool visited[2001][2001];
int rectangle[2001][2001];

int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};

void bfs(int x, int y) {
    queue<pair<int, int>> q;

    q.push({x,y});
    visited[y][x] = true;

    while(!q.empty()) {
        pair<int, int> p = q.front();
        q.pop();

        int xx = p.first;
        int yy = p.second;

        for(int i=0; i<4; i++){
            int nx = xx + dx[i];
            int ny = yy + dy[i];

            if(nx < 0 || nx > 2000 || ny < 0 || ny > 2000) continue;
            
            if(!visited[ny][nx] && rectangle[ny][nx]) {
                q.push({nx, ny});
                visited[ny][nx] = true;
            }
            
        }


    }


}

int main(){
    int N;
    cin >> N;

    while (N--) {
        int x1, y1, x2, y2;

        cin >> x1 >> y1 >> x2 >> y2;
        
        x1 = (x1 + 500) * 2;
        y1 = (y1 + 500) * 2;
        x2 = (x2 + 500) * 2;
        y2 = (y2 + 500) * 2;

        int xmax = max(x1, x2);
        int xmin = min(x1, x2);

        int ymax = max(y1, y2);
        int ymin = min(y1, y2);

        for (int i=xmin; i<=xmax; i++) {
            rectangle[y1][i] = 1;
            rectangle[y2][i] = 1;
        }

        for (int i=ymin; i<=ymax; i++) {
            rectangle[i][x1] = 1;
            rectangle[i][x2] = 1;
        }
    }

    bfs(1000, 1000);

    int answer = 0;
    
    for(int i=0; i<=2000; i++){
        for(int j=0; j<=2000; j++){
            if(!visited[i][j] && rectangle[i][j]){
                bfs(j,i);
                answer++;
            }
        }
    }

    cout << answer;

}