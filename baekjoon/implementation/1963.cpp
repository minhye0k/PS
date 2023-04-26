#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

bool prime[10000];
bool visited[10000];

int A;
int B;

void bfs(){
    queue<pair<int, int>> q;

    visited[A] = true;

    q.push({0,A});

    while(!q.empty()) {
        pair<int, int> p = q.front();
        int count = p.first;
        int number = p.second;

        q.pop();

        if (number == B){
            cout << count << '\n';
            return;
        }

        int remaining = number % 1000;

        for(int i=1; i<10; i++){ 
            int next = remaining + i*1000;
            if(!visited[next] && prime[next]){
                visited[next] = true;
                q.push({count+1, next});
            }
        }

        remaining = number % 100;

        for(int i=0; i<10; i++){
            int next = ((number/1000) * 1000) + remaining + i*100;
            if(!visited[next] && prime[next]){
                visited[next] = true;
                q.push({count+1, next});
            }
        }
        
        remaining = number % 10;

        for(int i=0; i<10; i++){
            int next = ((number/100) * 100) + remaining + i*10;
            if(!visited[next] && prime[next]){
                visited[next] = true;
                q.push({count+1, next});
            }
        }

        for(int i=0; i<10; i++){
            int next = ((number / 10) * 10) + i;
            if(!visited[next] && prime[next]){
                visited[next] = true;
                q.push({count+1, next});
            }
        }

    }
}

int main(){

    memset(prime, true, sizeof(prime));
    
    for(int i=2; i<=100; i++) {
        for(int j=i*i; j<=10000; j+=i){
            prime[j] = false;
        }
    }

    int T;
    cin >> T;

    while(T--){
        cin >> A >> B;

        memset(visited, false, sizeof(visited));
        bfs();

    }

}