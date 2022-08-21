#include <iostream>
#include <vector>

using namespace std;

int main(void){
    int N;
    cin >> N;

    vector< vector<int> > D(N+1, vector<int>(10));

    for(int i=0; i<10; i++){
        D[1][i] = 1;
    }

    for(int i=2; i<=N; i++){
        for(int j=0; j<=9; j++){
            for(int k=0; k<=j; k++){
                D[i][j] = (D[i][j] + D[i-1][k]) % 10007;
            }
        }
    }

    int answer = 0;
    for(int i=0; i<=9; i++){
        answer = (answer + D[N][i]) % 10007;
    }

    cout << answer << '\n';
}