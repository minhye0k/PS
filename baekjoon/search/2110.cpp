#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, C;
vector<int> v;

bool check(int x){
    int cnt = 1;
    int start = v[0];

    for(int i = 1; i< N; i++){
        
        int end = v[i];

        if(end - start >= x) {
            start = end;
            cnt++;
        }
    }

    return cnt >= C;
}

int main(void){
    cin >> N >> C;

    for(int i = 0; i<N; i++){
        int x;
        cin >> x;
        v.push_back(x);
    }

    sort(v.begin(), v.end());

    int lo = 1, hi = v[N-1] - v[0] + 1;

    while (lo + 1 < hi){
        int mid = (lo + hi) / 2;
        if(check(mid)) lo = mid;
        else hi = mid;

    }

    cout << lo << '\n';

}