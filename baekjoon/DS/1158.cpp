#include <iostream>
#include <queue>

using namespace std;

int main(void){
    int N, K;
    cin >> N >> K;

    cout << "<";

    queue<int> q;

    for(int i=1; i<=N; i++){
        q.push(i);
    }

    while(!q.empty()){
        for(int i=0; i<K-1; i++){
            int num = q.front();
            q.pop();
            q.push(num);
        }
        int num = q.front();
        q.pop();
        if(q.empty()){
            cout << num << '>';
        }else{
            cout << num << ", ";
        }

    }

}