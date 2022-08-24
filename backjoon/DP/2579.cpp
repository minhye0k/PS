#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void){
    int n;
    cin >> n;

    vector<int> d(n+1,0);
    vector<int> score(n+1, 0);

    for(int i=1; i<=n; i++){
        cin >> score[i];
    }

    d[1] = score[1];
    d[2] = score[1] + score[2];
    for(int i=3; i<=n; i++){
        d[i] =  score[i] + max(score[i-1] + d[i-3],  d[i-2]);
    }

    cout << d[n] << '\n';
}