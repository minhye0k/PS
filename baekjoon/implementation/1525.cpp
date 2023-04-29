#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <set>

using namespace std;

string s;
string answer = "123456780";

set<string> visited;
int ans = -1;

int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};

void bfs(){
    queue<pair<int, string>> q;
    visited.insert(s);
    q.push({0, s});

    while(!q.empty()){
        pair<int, string> p = q.front();
        q.pop();
        
        int cnt = p.first;
        string cur = p.second;

        if(cur == answer && (ans > cnt || ans == -1)){
            ans = cnt;
        }

        int n = cur.find("0");
        int x = n%3;
        int y = n/3;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > 2 || nx < 0 || ny > 2 || ny < 0){
                continue;
            }

            int index = 3 * ny + nx;

            string nexts = cur;

            char temp = nexts[index];
            nexts[index] = nexts[n];
            nexts[n] = temp;

            if(visited.find(nexts) == visited.end()){
                q.push({cnt + 1, nexts});
                visited.insert(nexts);
            }

        }

    }
    
}

int main(){
    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            char c;
            cin >> c;
            s += c;
        }
    }

    bfs();
    cout << ans;
}