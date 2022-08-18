#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
    int N;
    cin >> N;

    vector<int> D(N + 1);

    D[1] = 1;
    D[2] = 3;

    for (int i = 3; i <= N; i++)
    {
        D[i] = (D[i - 1] + 2 * D[i - 2]) % 10007;
    }

    cout << D[N] << '\n';
}