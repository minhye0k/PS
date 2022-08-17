#include <iostream>

using namespace std;

int main(void)
{
    int N;
    cin >> N;

    for (int i = 0; i < N; i++)
    {
        for (int k = 0; k < i; k++)
        {
            cout << " ";
        }
        for (int j = i; j < N; j++)
        {
            cout << "*";
        }

        for (int l = i; l < N - 1; l++)
        {
            cout << "*";
        }
        cout << '\n';
    }
    for (int i = 0; i < N - 1; i++)
    {
        for (int j = i + 1; j < N - 1; j++)
        {
            cout << " ";
        }
        for (int k = 0; k <= i; k++)
        {
            cout << "*";
        }
        for (int l = -1; l <= i; l++)
        {
            cout << "*";
        }
        cout << '\n';
    }
}