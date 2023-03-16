#include <iostream>
#include <vector>

using namespace std;

#define MAX 100001

int result[MAX];
bool visited[MAX];
vector<int> v[MAX];

void dfs(int k){
    visited[k] = true;

    for(int i=0; i<v[k].size(); i++){
        int next = v[k][i];
        if(!visited[next]){
            result[next] = k;
            dfs(next);
        }
    }

}

int main(){
    int N;
    cin >> N;

    for(int i=0; i<N-1; i++){
        int first, second;

        cin >> first >> second;

        v[first].push_back(second);
        v[second].push_back(first);
    }

    dfs(1);

    for(int i=2; i<=N; i++){

        cout << result[i] << "\n";
    }

}