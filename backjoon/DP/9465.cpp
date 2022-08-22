#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(void){
    int T;
    cin >> T;

    for(int i=0; i<T; i++){
        int n;
        cin >> n;

        vector<vector<int> > d(3, vector<int> (n+1, 0));
        vector<vector<int> > score(3, vector<int> (n+1, 0));
        for(int j=1; j<=n; j++){
            cin >> score[1][j];
        }
        for(int j=1; j<=n; j++){
            cin >> score[2][j];
        }

        d[1][1] = score[1][1];
        d[2][1] = score[2][1];
        d[1][2] = d[2][1] + score[1][2];
        d[2][2] = d[1][1] + score[2][2];

        for(int j=3; j<=n; j++){
            d[1][j] = score[1][j] + max(d[2][j-2], d[2][j-1]);
            d[2][j] = score[2][j] + max(d[1][j-2], d[1][j-1]);
        }

        cout << max(d[1][n], d[2][n]) << '\n';
    }
}