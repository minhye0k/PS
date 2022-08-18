#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
    int T;
    cin >> T;

    for (int i = 0; i < T; i++)
    {
        int n;
        cin >> n;

        vector<int> D(n + 1);

        D[1] = 1;
        D[2] = 2;
        D[3] = 4;

        for (int j = 4; j <= n; j++)
        {
            D[j] = D[j - 1] + D[j - 2] + D[j - 3];
        }

        cout << D[n] << '\n';
    }
}