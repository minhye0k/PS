#include <iostream>
#include <vector>
#define fastio cin.tie(0)->sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int N, M;

    cin >> N >> M;

    int * A = new int[N];
    int * B = new int[M];

    for(int i=0; i<N; i++){
        cin >> A[i];
    }

    for(int i=0; i<M; i++){
        cin >> B[i];
    }

    vector<int> result;

    int i = 0, j = 0;

    while(true) {
        if(i == N){
            while(j != M){
                result.push_back(B[j++]);
            }
            break;
        }else if(j == M){
            while(i != N){
                result.push_back(A[i++]);
            }
            break;
        }

        if (A[i] >= B[j]) {
            result.push_back(B[j++]);
        }else{
            result.push_back(A[i++]);
        }
    }

    for(int m = 0; m<result.size(); m++){
        cout << result[m] << " ";
    }
}