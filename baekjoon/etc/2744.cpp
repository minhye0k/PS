#include <iostream>
#include <cmath>

using namespace std;

int main(void){
    string N;
    int B;

    cin >> N >> B;


    int size = N.length();
    int result = 0;
    for(int i=0; i<size; i++){
        if(N.at(size-i-1) >='A' && N.at(size-i-1) <= 'Z'){
            int n = (N.at(size-i-1) - 'A') + 10;
            result += n * pow(B,i);
        }else{
            int n = N.at(size-i-1) - '0';
            result += n * pow(B,i);
        }
    }

    cout << result;
}