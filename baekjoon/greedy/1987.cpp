#include <iostream>
#include <algorithm>

using namespace std;

int R, C;
char board[20][20];

int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};

bool check[26];
int answer = 1;

void go(int x, int y, int d){
    answer = max(answer, d);

    for(int i=0; i<4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
        if(!check[board[nx][ny] - 'A']){
            check[board[nx][ny] - 'A'] = true;
            go(nx, ny, d+1);
            check[board[nx][ny] - 'A'] = false;
        }
    }
}

int main(){
    cin >> R >> C;

    for(int i=0; i<R; i++){
        for(int j=0; j<C; j++){
            cin >> board[i][j];
        }
    }

    check[board[0][0] - 'A'] = true;
    go(0,0,1);
    
    cout << answer;
    return 0;
}