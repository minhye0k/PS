#include <iostream>
#include <algorithm>

using namespace std;

long long num[9] = {0,0,1,7,4,2,0,8,10};
long long dp[101] = {0,0,1,7,4,2,6,8,10};

void memoization(){
    for(int i=9; i<=100; i++){
        dp[i] = dp[i-2] * 10 + num[2];
        for(int j=3; j<=7; j++){
            dp[i] = min(dp[i-j] * 10 + num[j], dp[i]);
        }
    }
}

int main() {


    int T;
    cin >> T;

    memoization();

    for(int i=0; i<T; i++){
        int n;
        cin >> n;
        cout << dp[n] << ' ';
        while(n){
            if (n % 2 == 1) {
                cout << "7";
                n -= 3;
            } else {
                cout << "1";
                n -= 2;
            }
        }

        cout << '\n';

    }

}