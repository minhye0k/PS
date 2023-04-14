#include <iostream>
#include <string>

using namespace std;

int main(){
    int n;
    cin >> n;

    char * original = new char[n];
    char * pupil = new char[n];

    cin >> original;
    cin >> pupil;

    int result = 0;

    for(int i=0; i<n; i++){
        if(original[i] != pupil[i]){
            result++;
        }
    }

    cout << result;
}