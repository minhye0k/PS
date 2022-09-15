#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>

using namespace std;

void dfs(int start, bool * visited, vector<vector<int> > &graph){
    visited[start] = true;
    cout << start << " ";
    int size = graph[start].size();
    for(int i=0; i<size; i++){
        int y = graph[start][i];
        if(!visited[y]) dfs(y, visited, graph);
    }
}

void bfs(int start, bool * visited, vector<vector<int> > &graph){
    queue<int> q;
    q.push(start);
    cout << start << " ";
    visited[start] = true;

    while(!q.empty()){
        int x = q.front();
        q.pop();

        int size = graph[x].size();

        for(int i=0; i<size; i++){
            int y = graph[x][i];
            if(!visited[y]){
                cout << y << " ";
                q.push(y);
                visited[y] = true;
            }
        }
    }
}

int main(void){
    
    int N,M,V;

    cin >> N >> M >> V;

    int start, end;

    vector<vector<int> > graph(N+1);

    bool * visited = new bool[N+1];

    for(int i=0; i<M; i++){
        cin >> start >> end;
        graph[start].push_back(end);
        graph[end].push_back(start);
    }

    for(int i=1; i<=N; i++){
        sort(graph[i].begin(), graph[i].end());
    }

    dfs(V, visited, graph);
    memset(visited, false, N+1 * sizeof(bool));
    cout << "\n";
    bfs(V, visited, graph);
    
}