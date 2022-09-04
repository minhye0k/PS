#include <iostream>

using namespace std;

int main(void)
{
    int A, B;
    while (cin >> A >> B)
    {
        if (A == 0 && B == 0)
        {
            return 0;
        }
        cout << A + B << '\n';
    }
}