#include <iostream>

using namespace std;

int main(void){
    int N;
    cin >> N;

    int result = 1;

    for(int i=2; i<=N; i++){
        result*=i;
    }

    cout << result;
}