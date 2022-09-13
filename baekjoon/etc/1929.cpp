#include <iostream>
#include <string.h>

using namespace std;

int main(void){
    int M, N;
    cin >> M >> N;

    bool arr[N+1];
    memset(arr, true, sizeof(arr));
    arr[0] = arr[1] = false;
    

    for(int i=2; i*i<=N; i++){

        if(arr[i]){
            for(int j = i*i; j<=N; j+=i){
                arr[j] = false;        
            }
        }
    }

    for(int i=M; i<=N; i++){
        if(arr[i]){
            cout << i << '\n';
        }
    }
}