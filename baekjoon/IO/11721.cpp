#include <iostream>

using namespace std;

int main(void)
{
    string s;

    getline(cin, s);

    int size = s.size();
    int index = 0;

    while (index < size)
    {
        for (int i = 0; i < 10; i++)
        {

            if (i + index >= size)
            {
                break;
            }
            cout << s.at(i + index);
        }
        cout << '\n';
        index = index + 10;
    }

    return 0;
}