#include <iostream>
#include <string>
#include <cstring>

using namespace std;

int main(void)
{
    char str[101];

    while (cin.getline(str, 101))
    {

        if (strcmp(str, "") == 0)
            break;
        cout << str << '\n';
    }
}