#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int A, B, C;
bool visited[201][201][201];

void bfs() {
    vector<int> v;
    queue<pair<int, pair<int, int>>> q;

    q.push({0,{0, C}});

    while(!q.empty()){
        pair<int, pair<int,int>> p = q.front();
        q.pop();


        int a = p.first;
        int b = p.second.first;
        int c = p.second.second;

        if(visited[a][b][c]) continue;
        visited[a][b][c] = true;

        if(a == 0){
            v.push_back(c);
        }

        if(a > B - b) q.push({a - (B - b), {B, c}});
        else q.push({0, {a+b, c}});

        if(a > C - c) q.push({a - (C - c), {b, C}});
        else q.push({0, {b, a+c}});

        if(b > A - a) q.push({A, {b - (A - a), c}});
        else q.push({a+b, {0, c}});

        if(b > C - c) q.push({a, {b - (C - c), C}});
        else q.push({a, {0, b+c}});

        if(c > A - a) q.push({A, {b, c - (A - a)}});
        else q.push({c+a, {b, 0}});

        if(c > B - b) q.push({a, {B, c - (B - b)}});
        else q.push({a, {c+b, 0}});

    }

    sort(v.begin(), v.end());

    for(int result : v){
        cout << result << " ";
    }
    
}

int main() {
    cin >> A >> B >> C;

    bfs();
}