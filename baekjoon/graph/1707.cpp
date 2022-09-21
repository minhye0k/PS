#include <iostream>
#include <vector>
#include <string>
#include <cstring>

#define RED 3
#define BLUE 4

using namespace std;

void dfs(int start, int * visited, vector<vector<int> > &graph){
    if(!visited[start]) visited[start] = RED;
    int size = graph[start].size();

    for(int i=0; i<size; i++){
        int v = graph[start][i];
        if(!visited[v]){
            if(visited[start] == RED){
                visited[v] = BLUE;
            }else if(visited[start] == BLUE){
                visited[v] = RED;
            }

            dfs(v, visited, graph);
        }
    }

}

bool isBipartiteGraph(int * visited, vector<vector<int> > &graph){
    int size = graph.size() - 1;
    for(int i=1;i<=size; i++){
        int gsize = graph[i].size();
        for(int j=0; j<gsize; j++){
            int next = graph[i][j];
            if(visited[i] == visited[next]){
                return false;
            }
        }
    }
    return true;
}

int main(void){
    int K;
    cin >> K;
    int V, E;

    for(int j=0; j<K; j++){
        cin >> V >> E;
        vector<vector<int> > graph(V+1);
        int * visited = new int[V+1];

        memset(visited, 0, (V+1) * sizeof(int));

        for(int i=0; i<E; i++){
            int start, end;
            cin >> start >> end;
            graph[start].push_back(end);
            graph[end].push_back(start);
        }

        for(int i=1; i<=V; i++){

            if(!visited[i]){
                
                dfs(i, visited, graph);
            }

        }

        

        if(!isBipartiteGraph(visited, graph)){
            cout << "NO\n";
        }else{
            cout << "YES\n";
        }
        
    }
}