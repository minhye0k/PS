#include <iostream>

using namespace std;

int main(void)
{
    int N;
    cin >> N;

    for (int i = 0; i < N; i++)
    {
        for (int j = -1; j < i; j++)
        {
            cout << "*";
        }
        cout << "\n";
    }
}