#include <iostream>
#include <vector>

using namespace std;
vector<int> graph[1001];
bool isVisited[1001];

void dfs(int start){
    isVisited[start] = true;

    int size = graph[start].size();
    for(int i=0; i<size; i++){
        int next = graph[start][i];
        if(!isVisited[next]){
            dfs(next);
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    int N;

    for(int i=0; i<T; i++){
        cin >> N;

        for(int j=1; j<=N; j++){
            graph[j].clear();
            isVisited[j] = false;
        }

        for(int j=1; j<=N; j++){
            int v;
            cin >> v;

            graph[j].push_back(v);
        }

        int componentCnt = 0;

        for(int j=1; j<=N; j++){
            if(!isVisited[j]){
                dfs(j);
                componentCnt++;
            }
        }

        cout << componentCnt << '\n';
    }
}