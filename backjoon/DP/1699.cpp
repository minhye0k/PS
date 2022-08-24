#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(void){
    int N;
    cin >> N;

    vector<int> d(N+1, 0);

    for(int i=1; i<=N; i++){
        d[i] = i;
        for(int j=1; j*j<=i; j++){
            d[i] = min(d[i], d[i-j*j] + 1);
        }
    }

    cout << d[N] << '\n';

}