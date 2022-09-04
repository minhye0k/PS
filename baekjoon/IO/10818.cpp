#include <iostream>

using namespace std;

int main(void)
{
    int N;
    cin >> N;

    int arr[N];

    int max = 0;
    int min = 0;

    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
        if (i == 0)
        {
            max = arr[i];
            min = arr[i];
            continue;
        }
        if (arr[i] > max)
        {
            max = arr[i];
        }

        if (arr[i] < min)
        {
            min = arr[i];
        }
    }

    cout << min << " " << max;

    return 0;
}