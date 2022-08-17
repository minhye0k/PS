#include <iostream>

using namespace std;

int main(void)
{
    int N;
    cin >> N;

    int total = 0;
    for (int i = 1; i <= N; i++)
    {
        total += i;
    }

    cout << total;
}