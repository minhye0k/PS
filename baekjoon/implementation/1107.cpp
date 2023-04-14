#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

bool broken[10];

int possible(int c){
    if(c / 10 == 0){
        if(broken[c]){
            return 0;
        }
        return 1;
    }
    int len = 0;

    while(c > 0){
        if(broken[c % 10]){
            return 0;
        }
        c/=10;
        len++;
    }

    return len;
}

int main() {
    int N;
    cin >> N;

    int M;
    cin >> M;

    for(int i=0; i<M; i++){
        int num;
        cin >> num;
        broken[num] = true;
    }

    int ans = abs(N - 100);

    for (int i=0; i<=1000000; i++) {
        if(!possible(i)){
            continue;
        }

        int len = possible(i);

        if(ans > len + abs(N-i)) {
            ans = len + abs(N-i);
        }
    }

    cout << ans;
}