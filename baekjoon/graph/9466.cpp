#include <iostream>
#include <vector>

using namespace std;

bool visited[100001];
int want[100001];
bool done[100001];
int cnt;

void dfs(int start){
    visited[start] = true;

    int next = want[start];

    if(!visited[next]){
        dfs(next);
    }
    else if(!done[next]){
        for(int i=next; i != start; i = want[i]){
            cnt++;
        }
        cnt++;
    }

    done[start] = true;
}

int main(void){
    int T;
    cin >> T;

    int N;
    while(T--){
        cin >> N;

        cnt = 0;

        for(int i=1; i<=N; i++){
            visited[i] = 0;
            done[i] = 0;
        }

        for(int i=1; i<=N; i++){
            cin >> want[i];
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                dfs(i);
            }
        }

        cout << N - cnt << '\n';
    }
}