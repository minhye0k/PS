#include <iostream>
#include <cstring>

using namespace std;

int main(void){
    string S;
    cin >> S;

    int size = S.length();

    int arr[26] = {-1};

    memset(arr, -1, 26*sizeof(int));

    for(int i=0; i<size; i++){
        int num = S.at(i) - 'a';
        if(arr[num] == -1){
            arr[num] = i;
        }
    }

    for(int i=0; i<26; i++){
        cout << arr[i] << ' ';
    }
}