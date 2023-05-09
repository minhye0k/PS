#include <bits/stdc++.h>

using namespace std;

#define MAX 1000001

int F, S, G, U, D;

int position[MAX];
bool visited[MAX];
int dx[2];

void bfs() {
    queue<int> q;
    q.push(S);
    visited[S] = true;

    while(!q.empty()){
        int pos = q.front();
        q.pop();

        for(int i=0; i<2; i++){
            int npos = pos + dx[i];

            if(npos < 1 || npos > F) continue;
            if(!visited[npos]){
                q.push(npos);
                position[npos] = position[pos] + 1;
                visited[npos] = true;
            }

        }
    }

}

int main() {
    cin >> F >> S >> G >> U >> D;
    dx[0] = U;
    dx[1] = -D;

    bfs();

    if(visited[G]){
        cout << position[G];
    }else{
        cout << "use the stairs";
    }

}