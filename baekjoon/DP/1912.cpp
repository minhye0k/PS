#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void){
    int n;
    cin >> n;

    vector<int> d(n+1, 0);
    vector<int> arr(n+1, 0);

    for(int i=1; i<=n; i++){
        cin >> arr[i];
        d[i] = arr[i];
    }

    int answer = d[1];

    for(int i=2; i<=n; i++){
        d[i] = max(d[i-1] + arr[i], arr[i]);
        cout << d[i] << ' ';
        answer = max(answer, d[i]);
    }

    cout<< answer << '\n';

}