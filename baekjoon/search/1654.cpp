#include <iostream>

using namespace std;


int arr[10001];
int K, N;

bool check(long long x) {
    int sum = 0;
    for(int i=0; i<K; i++){
        sum += (arr[i] / x);
    }
    return sum >= N;
}

int main() {
    cin >> K >> N;

    long long max = 0;

    for(int i=0; i<K; i++){
        cin >> arr[i];
        if(arr[i] > max){
            max = arr[i];
        }

    }

    long long lo = 1, hi = max + 1;
    int ans = 0;
    while(lo + 1 < hi){
        long long mid = (lo + hi) / 2;
        if(check(mid)){
            lo = mid;
        }
        else {
            hi = mid;
        }
    }

    cout << lo << '\n';

    return 0;

}