#include <iostream>
#include <vector>

using namespace std;

int main(void){
    int T;
    cin >> T;
    vector<long> d(101,0);
    d[1] = 1;
    d[2] = 1;
    d[3] = 1;
        
    for(int i=0; i<T;i++){
        int N;
        cin >> N;

        for(int i=4; i<=N; i++){
            d[i] = d[i-3] + d[i-2];
        }

        cout << d[N] << '\n';
    }
}