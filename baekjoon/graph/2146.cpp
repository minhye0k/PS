#include <iostream>
#include <vector>
#include <queue>
#include <cstdlib>

using namespace std;

#define MAX 101

int land[MAX][MAX];
int N;
int result = 2e9;

int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};

vector<pair<int, int> > corner;

void land_label(int y, int x, int cnt){
    queue<pair<int, int> > q;
    q.push(make_pair(y, x));

    while(!q.empty()){
        pair<int, int> p = q.front();
        q.pop();

        bool edge = false;

        land[p.first][p.second] = cnt;

        for(int i=0; i<4; i++){
            int nx = p.second + dx[i];
            int ny = p.first + dy[i];

            if(nx < 1 || nx > N || ny < 1 || ny > N){
                continue;
            }
            
            if(land[ny][nx] == 0) {
                edge = true;
            } else if(land[ny][nx] == -1){
                q.push(make_pair(ny, nx));
                land[ny][nx] = cnt;
            }
        }

        if(edge) corner.push_back(make_pair(p.first, p.second));
    }
}

int main(){
    int cnt = 0;
    cin >> N;

    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            cin >> land[i][j];

            if(land[i][j] == 1) land[i][j] = -1;
        }
    }

    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            if(land[i][j] == -1){
                land_label(i,j, ++cnt);

            }
        }
    }

    int size = corner.size();

    for(int i=0; i<size-1; i++){
        int x = corner[i].second;
        int y = corner[i].first;

        for (int j=i+1; j<size; j++){
            int xx = corner[j].second;
            int yy = corner[j].first;
            if(land[yy][xx] != land[y][x]){
                int distance = abs(x-xx) + abs(y-yy) - 1;

                if(distance < result){
                    result = distance;
                }
            }
        }
    }

    cout << result << endl;
}
