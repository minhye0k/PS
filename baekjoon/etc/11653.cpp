#include <iostream>

using namespace std;

int main(void){
    int N;
    cin >> N;

    if(N==1){
        return 0;
    }

    
    int div = 2;

    while(N!=1){
        if(N%div == 0){
            cout << div << '\n';
            N/=div;
        }else{
            div++;
        }
    }
}