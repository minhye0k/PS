#include <bits/stdc++.h>

using namespace std;

int S[13];
vector<int> v;
bool visited[13];
int k;

void dfs(int cnt, int index){
    if(cnt == 6) {
        for(auto num : v){
            cout << num << " ";
        }
        cout << '\n';
        return;
    }

    for(int i=index+1; i<k; i++){
        if(!visited[i]){
            visited[i] = true;
            v.push_back(S[i]);
            dfs(cnt + 1, i);
            visited[i] = false;
            v.pop_back();
        }
    }

}

int main() {
    int cnt = 0;
    while(true) {
        if(cnt!=0) cout << '\n';
        cin >> k;
        if(!k) break;

        v.clear();
        memset(visited, false, sizeof(visited));
        memset(S, 0, sizeof(S));
        
        for(int i=0; i<k; i++) cin >> S[i];

        dfs(0, -1);

        cnt++;
    }
}