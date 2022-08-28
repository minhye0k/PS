#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void){
    int N;
    vector<int> p(N+1,0);
    vector<int> d(N+1, 0);

    cin >> N;

    for(int i=1; i<=N; i++){
        cin >> p[i];
    }

    d[1] = p[1];

    for(int i=1; i<=N; i++){
        for(int j=1; j<=i; j++){
            d[i] = max(d[i], d[i-j] + p[j]);    
        }
    }

    cout << d[N] << '\n';
}