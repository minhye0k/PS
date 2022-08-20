#include <iostream>
#include <vector>

using namespace std;

int main(void)
{

    int N;
    cin >> N;

    vector<vector<int> > D(10, vector<int>(N + 1));

    for (int i = 1; i <= 9; i++)
    {
        D[i][1] = 1;
    }
    for (int j = 1; j <= 9; j++)
    {
        for (int i = 2; i <= N; i++)
        {
            if (j == 1)
            {
                D[j][i] = D[j + 1][i - 1] % 1000000000;
            }
            else if (j == 9)
            {
                D[j][i] = D[j - 1][i - 1] % 1000000000;
            }
            else
            {
                D[j][i] = (D[j - 1][i - 1] + D[j + 1][i - 1]) % 1000000000;
            }
        }
    }

    int answer = 0;
    for (int i = 1; i <= 9; i++)
    {
        answer += D[i][N];
    }

    cout << answer << '\n';
}