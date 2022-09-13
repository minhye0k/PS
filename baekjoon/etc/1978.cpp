#include <iostream>
#include <string.h>

using namespace std;

int main(void){
    bool arr[1001];
    memset(arr, true,sizeof(arr));

    arr[0] = arr[1] = false;
    for(int i=2; i*i<=1000; i++){

        if(arr[i]){
            for(int j=i*i; j<=1000; j+=i){
                arr[j] = false;
            }
        }
    }

    int N;
    int result = 0;
    cin >> N;
    for(int i=0; i<N; i++){
        int index;
        cin >> index;
        if(arr[index]) result++;
    }
    
    cout << result;
}