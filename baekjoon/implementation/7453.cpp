#include <iostream>
#include <vector>
#include <algorithm>
#define fastio cin.tie(0) -> sync_with_stdio(0)

using namespace std;

int main() {
    fastio;

    long long result = 0;

    vector<long long> sumAB;
    vector<long long> sumCD;

    vector<int> A;
    vector<int> B;
    vector<int> C;
    vector<int> D;

    int n;
    cin >> n;

    for(int i=0; i<n; i++) {
        int num;
        cin >> num;
        A.push_back(num);
        cin >> num;
        B.push_back(num);
        cin >> num;
        C.push_back(num);
        cin >> num;
        D.push_back(num);
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            int sum = A[i] + B[j];
            sumAB.push_back(sum);
        }
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            int sum = C[i] + D[j];
            sumCD.push_back(sum);
        }
    }

    sort(sumAB.begin(), sumAB.end());
    sort(sumCD.begin(), sumCD.end());

    for(int i=0; i<sumAB.size(); i++){
        int target = -sumAB[i];

        result += upper_bound(sumCD.begin(), sumCD.end(), target) - lower_bound(sumCD.begin(), sumCD.end(), target);
    }

    cout << result;
}