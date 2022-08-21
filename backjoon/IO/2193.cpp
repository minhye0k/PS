#include <iostream>
#include <vector>

using namespace std;

int main(void){
    int N;
    cin >> N;

    vector< vector<long> > D(N+1, vector<long> (2,0));

    D[1][1] = 1;

    for(int i=2; i<=N; i++){
        for(int j=0; j<=1; j++){
            if(j==0){
                D[i][j] = D[i-1][j] + D[i-1][j+1];
            }
            else{
                D[i][j] = D[i-1][j-1];
            }
        }
    }

    long answer = 0;
    for(int i=0; i<=1; i++){
        answer += D[N][i];
    }

    cout << answer << '\n';
}