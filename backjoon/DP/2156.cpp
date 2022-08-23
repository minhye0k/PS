#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void){
    int n;
    cin >> n;

    vector<long> d(n+1,0);
    vector<long> amount(n+1, 0);

    for(int i=1; i<=n; i++){
        cin >> amount[i];
    }

    d[1] = amount[1];
    d[2] = d[1] + amount[2];

    for(int i=3; i<=n; i++){
        d[i] = max(d[i-1], amount[i] + max(d[i-3] +amount[i-1], d[i-2]));
    }

    cout << d[n] << '\n';
    
}