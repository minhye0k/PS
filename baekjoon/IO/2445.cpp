#include <iostream>

using namespace std;

int main(void)
{
    int N;
    cin >> N;

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            cout << "*";
        }

        for (int k = i; k < N - 1; k++)
        {
            cout << " ";
        }

        for (int m = i; m < N - 1; m++)
        {
            cout << " ";
        }

        for (int l = 0; l <= i; l++)
        {
            cout << "*";
        }

        cout << "\n";
    }

    for (int i = 0; i < N - 1; i++)
    {

        for (int k = i; k < N - 1; k++)
        {
            cout << "*";
        }

        for (int j = 0; j <= i; j++)
        {
            cout << " ";
        }

        for (int l = 0; l <= i; l++)
        {
            cout << " ";
        }

        for (int m = i; m < N - 1; m++)
        {
            cout << "*";
        }

        cout << "\n";
    }
}