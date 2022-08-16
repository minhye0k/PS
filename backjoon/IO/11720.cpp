#include <iostream>

using namespace std;

int main(void)
{
    int N;
    cin >> N;
    string str;
    cin >> str;
    int total = 0;

    for (char &s : str)
    {

        int num = s - '0';
        total += num;
    }
    cout << total;
}