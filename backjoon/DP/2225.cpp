#include <iostream>
#include <vector>

using namespace std;

int main(void){
    int N,K;

    cin >> N >> K;

    vector<vector<long> > d(K+1, vector<long>(N+1, 0));

    for(int i=0; i<=N; i++){
        d[1][i] = 1;
    }

    for(int i=2; i<=K; i++){
        for(int j=0; j<=N; j++){
            for(int k=0; k<=j; k++){
                d[i][j] = (d[i][j] + d[i-1][k])%1000000000;
            }
        }
    }

    cout << d[K][N] << '\n';


}