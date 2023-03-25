#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

#define MAX 100001

int maxDistance = 0;
int maxV = 0;

bool visited[MAX];
vector<pair<int, int> > tree[MAX];


void dfs(int x, int distance){
    if(visited[x]){
        return;
    }
    visited[x] = true;

    vector<pair<int, int> > v = tree[x];
    if (maxDistance < distance) {
        maxDistance = distance;
        maxV = x;
    }

    int size = v.size();

    for(int i=0; i<size; i++){
        pair<int, int> p = v[i];

        int nextV = p.first;
        int nextDis = p.second;

        dfs(nextV, distance + nextDis);
    }
    
}

int main(){

	int V;
	cin >> V;

	for (int i=0; i<V; i++) {
		int start;
		cin >> start;

		while (true) {
			pair<int, int> p;
			cin >> p.first;

			if (p.first == -1){
				break;
			}
			cin >> p.second;

			tree[start].push_back(p);

		}
	}

    dfs(1,0);

    memset(visited, false, sizeof(visited));

    maxDistance = 0;

    dfs(maxV, maxDistance);

    cout << maxDistance << '\n';


}
