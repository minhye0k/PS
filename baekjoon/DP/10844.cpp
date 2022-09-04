#include <iostream>
#include <vector>

using namespace std;

int main(void)
{

    int N;
    cin >> N;

    vector<vector<int> > D(N+1, vector<int>(10, 0));

    for (int i = 1; i <= 9; i++)
    {
        D[1][i] = 1;
    }
    for (int j = 2; j <= N; j++)
    {
        for (int i = 0; i <= 9; i++)
        {
            if (i == 0)
            {
                D[j][i] = D[j-1][i+1]% 1000000000;
            }
            else if (i == 9)
            {
                D[j][i] = D[j-1][i-1] % 1000000000;
            }
            else
            {
                D[j][i] = (D[j - 1][i - 1] + D[j -1][i + 1]) % 1000000000;
            }
        }
    }

    int answer = 0;
    for (int i = 0; i <= 9; i++)
    {
        answer = (answer + D[N][i]) % 1000000000;
    }

    cout << answer % 1000000000 << '\n';
}