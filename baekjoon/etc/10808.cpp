#include <iostream>

using namespace std;

int main(void){
    string S;
    cin >> S;

    int size = S.length();

    int arr[26] = {0};
    

    for(int i=0; i<size; i++){
        int num = S.at(i) - 'a';
        arr[num]++;
    }

    for(int i=0; i<26; i++){
        cout << arr[i] << " ";
    }
}