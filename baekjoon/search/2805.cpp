#include <iostream>

using namespace std;

int N, M;
int arr[1000000];

bool check(int x){
    long long sum = 0;
    for(int i=0; i<N; i++){
        if(arr[i] - x > 0) sum += arr[i] - x;
    }
    return sum >= M;
}

int main(){
    cin >> N >> M;

    for(int i=0; i<N; i++){
        cin >> arr[i];
    }

    int lo = 0, hi = 1e9;


    while(lo + 1 < hi){
        int mid = (lo + hi) / 2;
        if(check(mid)) lo = mid;
        else hi = mid;
    }

    cout << lo << '\n';



}