#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> vA;
vector<int> vB;

int main() {
    long long result = 0;
    int T, n, m;

    cin >> T;
    cin >> n;

    int * A = new int[n];

    for(int i=0; i<n; i++){
        cin >> A[i];
    }

    cin >> m;
    
    int * B = new int[m];

    for(int i=0; i<m; i++){
        cin >> B[i];
    }

    for(int i=0; i<n; i++){
        int sum = 0;
        for(int j=i; j<n; j++){
            sum += A[j];
            vA.push_back(sum);
        }
    }

    for(int i=0; i<m; i++){
        int sum = 0;
        for(int j=i; j<m; j++){
            sum += B[j];
            vB.push_back(sum);
        }
    }

    sort(vB.begin(), vB.end());

    for(int i=0; i<vA.size(); i++){
        int target = T - vA[i];
        result += upper_bound(vB.begin(), vB.end(), target) - lower_bound(vB.begin(), vB.end(), target);
    }

    cout << result;
    
}