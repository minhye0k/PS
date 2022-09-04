#include <iostream>

using namespace std;

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    int arr[10001] = {0};

    for(int i=0; i<N;i++){
        int a;
        cin >> a;
        arr[a]++;
    }

    for(int i=1; i<10001; i++){
        int a = arr[i];
        for(int j=0; j<a; j++){
            cout << i << '\n';
        }
    }

}