#include <iostream>
#include <vector>

using namespace std;

void dfs(int start, bool * visited, vector<vector<int> > &graph){
    visited[start] = true;
    int size = graph[start].size();
    for(int i=0; i<size; i++){
        int x = graph[start][i];
        if(!visited[x]) dfs(x, visited, graph);
    }
}

int main(void){
    int componentCount = 0;

    int N,M;
    cin >> N >> M;

    bool * visited = new bool[N+1];
    vector<vector<int> > graph(N+1);

    int start, end;
    for(int i=0; i<M; i++){
        cin >> start >> end;
        
        graph[start].push_back(end);
        graph[end].push_back(start);
    }

    for(int i=1; i<=N; i++){
        
        if(!visited[i]){
            dfs(i,visited, graph);
            componentCount++;
        }
    }

    cout << componentCount;

}