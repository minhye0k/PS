#include <iostream>
#include <queue>

using namespace std;

bool visited[100000];
int N, K;

void bfs() {
    queue<pair<int, int>> q;
    q.push({0, N});

    visited[N] = true;

    while(!q.empty()){
        pair<int, int> p = q.front();
        
        int second = p.first;

        int x = p.second;

        if (x==K) {
            cout << second;
            return;
        }

        q.pop();

        if(x+1 <= 100000){
            if(!visited[x+1]){
                visited[x+1] = true;
                q.push({second + 1, x+1});
            }
        }

        if(x-1 >= 0){
            if(!visited[x-1]){
                visited[x-1] = true;
                q.push({second + 1, x-1});
            }
        }

        if(x*2 <= 100000){
            if(!visited[x*2]){
                visited[x*2] = true;
                q.push({second + 1, x * 2});

            }
        }
    }

}

int main(){
    cin >> N >> K;

    bfs();

}