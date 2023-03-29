#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, M;
vector<int> hasCard;
int has[500000];

bool check(int x, int num) {
    return num >= hasCard[x];
}

int main(void) {
    cin >> M;

    for(int i=0; i<M; i++){
        int n;
        cin >> n;

        hasCard.push_back(n);
    }

    sort(hasCard.begin(), hasCard.end());

    int minimum = hasCard[0];
    int maximum = hasCard[hasCard.size() - 1];

    cin >> N;

    for(int i=0; i<N; i++){
        int n;
        cin >> n;

        if(n < minimum || n > maximum){
            continue;
        }

        int lo = 0, hi = hasCard.size();

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if(check(mid, n)) lo = mid;
            else hi = mid;
        }

        if(hasCard[lo] == n){
            has[i] = 1;
        }
    }   

    for(int i=0; i<N; i++){
        cout << has[i] << " ";
    }


}