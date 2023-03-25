#include <iostream>
#include <vector>
#include <cstring>

#define MAX 10001

using namespace std;

vector<pair<int, int> > tree[MAX];
bool visited[MAX];

int maxDistance = 0;
int maxNode = 0;

void dfs(int x, int distance) {
    if(visited[x]){
        return;
    }

    visited[x] = true;
    
    if(maxDistance < distance){
        maxDistance = distance;
        maxNode = x;
    }

    int size = tree[x].size();

    for(int i=0; i<size; i++){

        int weight = tree[x][i].second;
        dfs(tree[x][i].first, distance + weight);
    }

}

int main() {
    int n;
    cin >> n;

    for(int i=0; i<n-1; i++) {
        int v;
        int u;
        int w;

        cin >> v;
        cin >> u;
        cin >> w;

        tree[v].push_back(make_pair(u,w));
        tree[u].push_back(make_pair(v,w));
    }

    dfs(1, 0);

    maxDistance = 0;
    memset(visited, false, sizeof(visited));

    dfs(maxNode, 0);

    cout << maxDistance << '\n';


}