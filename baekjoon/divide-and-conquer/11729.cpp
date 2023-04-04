#include <iostream>
#include <cmath>

#define fastio cin.tie(0) -> sync_with_stdio(0)

using namespace std;

void hanoi(int n, int start, int pass, int end){
    if(n == 1){
        cout << start << " " << end << '\n';
    }else{
        hanoi(n-1, start, end, pass);
        cout << start << " " << end << '\n';
        hanoi(n-1, pass, start, end);
    }
}

int main(void) {
    fastio;

    int N;
    cin >> N;

    int K = pow(2, N) - 1;    
    cout << K << '\n';

    hanoi(N, 1, 2, 3);

}