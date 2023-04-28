#include <iostream>
#include <queue>
#include <vector>
#include <cstring>

using namespace std;

bool visited[10001];

int A, B;

void bfs(){
    visited[A] = true;
    queue<pair<int, string>> q;
    q.push({A, ""});

    while(!q.empty()){
        pair<int, string> p = q.front();
        int n = p.first;
        string str = p.second;
        q.pop();

        if(n == B){
            cout << str << '\n';
            return;
        }


        int d = (n*2) % 10000;
        if(!visited[d]){
            q.push({d, str + "D"});
            visited[d] = true;
        }

        int s = n-1;
        if(n==0){
            s = 9999;
        }

        if(!visited[s]){
            q.push({s, str + "S"});
            visited[s] = true;
        }

        int l = (n % 1000) * 10 + (n/1000);
        if(!visited[l]){
            q.push({l, str + "L"});
            visited[l] = true;
        }
        
        int r = (n / 10) + (n%10) * 1000;
        if(!visited[r]){
            q.push({r, str + "R"});
            visited[r] = true;
        }
        
    }
}

int main(){
    int T;
    cin >> T;

    while(T--){
        cin >> A >> B;
        memset(visited, false, sizeof(visited));
        bfs();

    }
}