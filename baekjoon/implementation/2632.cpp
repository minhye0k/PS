#include <iostream>
#include <algorithm>
#include <vector>
#define fastio cin.tie(0)->sync_with_stdio(0)

using namespace std;

vector<int> vA;
vector<int> vB;

int main() {
    int N;
    
    cin >> N;

    int m, n;

    cin >> m >> n;

    int * pizzaA = new int[m];
    int * pizzaB = new int[n];

    for(int i=0; i<m; i++){
        cin >> pizzaA[i];
    }

    for(int i=0; i<n; i++){
        cin >> pizzaB[i];
    }

    for(int i=0; i<m; i++){
        int sum = 0;
        for(int j=0; j<m-1; j++){
            sum += pizzaA[(i+j)%m];
            vA.push_back(sum);
        }

        if(i == m-1){
            sum += pizzaA[m-2];
            vA.push_back(sum);
        }
    }   

    for(int i=0; i<n; i++){
        int sum = 0;
        for(int j=0; j<n-1; j++){
            sum += pizzaB[(i+j)%n];
            vB.push_back(sum);
        }

        if(i == n-1){
            sum += pizzaB[n-2];
            vB.push_back(sum);
        }
    }

    vB.push_back(0);
    vA.push_back(0);

    sort(vB.begin(), vB.end());

    long long result = 0;

    for(int i=0; i<vA.size(); i++){
        int target = N - vA[i];

        result += upper_bound(vB.begin(), vB.end(), target) - lower_bound(vB.begin(), vB.end(), target);
    }

    cout << result;


    
}