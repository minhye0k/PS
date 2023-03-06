#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cstdio>

using namespace std;

int home[26][26] = {0};
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
int checked[26][26] = {0};
int group[26 * 26] = {0};
int N;

void bfs(int x, int y, int cnt){

    queue<pair<int,int> > q;
    
    q.push(make_pair(x,y));
    checked[y][x] = cnt;
    group[cnt]++;

    while(!q.empty()) {

        pair<int, int> p = q.front();
        q.pop();

        for(int i = 0; i < 4; i++){
            int nextX = p.first + dx[i];
            int nextY = p.second + dy[i];

            if(nextX <1 || nextX>N || nextY <1 || nextY >N){
                continue;
            }

            if(!checked[nextY][nextX] && home[nextY][nextX]){
                pair<int, int> next = make_pair(nextX, nextY);
                checked[nextY][nextX] = cnt;
                group[cnt]++;
                q.push(next);
            }
        } 
    }


}

int main(){

    cin >> N;

    int cnt = 1;

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            scanf("%1d", &home[i][j]);
        }
    }

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            if (!checked[i][j] && home[i][j] == 1) {
                bfs(j, i ,cnt++);
            }
        }
    }

    sort(group+1, group + cnt);
    
    cout << cnt - 1 << endl;

    for(int i=1; i<cnt; i++) {
        cout << group[i] << endl;
    }

}