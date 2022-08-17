#include <iostream>

using namespace std;

int main(void)
{
    int x, y;
    cin >> x >> y;

    int numberOfDay[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    string dayOfTheWeek[7] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    int totalDays = 0;

    for (int i = 0; i < x - 1; i++)
    {
        totalDays += numberOfDay[i];
    }

    totalDays += y - 1;

    cout << dayOfTheWeek[totalDays % 7];

    return 0;
}