#include <iostream>

using namespace std;

long long ans = 0;
int n;

void dfs(int sum, int num){
    if((sum + num) == n){
        ans++;
        return;
    }

    sum = sum + num;

    if(sum + 1 <= n){
        dfs(sum, 1);
    }

    if(sum + 2 <= n){
        dfs(sum, 2);
    }

    if(sum + 3 <= n){
        dfs(sum, 3);
    }
}

int main() {
    int T;
    cin >> T;

    while (T--) {
        ans = 0;
        cin >> n;
        dfs(0, 0);

        cout << ans << '\n';
    }
}