#include <iostream>
#include <string>
#include <cstring>

using namespace std;

int main(void)
{
    string str;

    while (getline(cin, str))
    {
        cout << str << '\n';
    }
}