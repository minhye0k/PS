#include <iostream>
#include <algorithm>
#include <vector>
#define fastio cin.tie(0)->sync_with_stdio(0)


using namespace std;

int N, M;
vector<int> hasCard;
int has[500000];
int minimum, maximum;


int lower_bound(int x){
    int lo = -1, hi = hasCard.size();

    while(lo + 1 < hi){
        int mid = (lo + hi) / 2;
        if(hasCard[mid] < x) lo = mid;
        else hi = mid;
    }

    return hi;
}

int upper_bound(int x){
    int lo = -1, hi = hasCard.size();

    while(lo + 1 < hi){
        int mid = (lo + hi) / 2;

        if(hasCard[mid] <= x) lo = mid;
        else hi = mid;
    }

    return hi;
}

int main(void) {
    fastio;
    
    cin >> M;

    for(int i=0; i<M; i++){
        int n;
        cin >> n;

        hasCard.push_back(n);
    }

    sort(hasCard.begin(), hasCard.end());

    minimum = hasCard[0];
    maximum = hasCard[hasCard.size() - 1];

    cin >> N;

    for(int i=0; i<N; i++){
        int n;
        cin >> n;

        cout << upper_bound(n) - lower_bound(n) << ' ';
    }


}