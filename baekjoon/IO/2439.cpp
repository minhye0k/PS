#include <iostream>

using namespace std;

int main(void)
{
    int N;
    cin >> N;

    for (int i = 0; i < N; i++)
    {
        for (int j = i; j < N - 1; j++)
        {
            cout << " ";
        }
        for (int k = -1; k < i; k++)
        {
            cout << "*";
        }
        cout << '\n';
    }

    return 0;
}