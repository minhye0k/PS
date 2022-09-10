#include <iostream>
#include <cmath>

using namespace std;

long long  gcd(long long  A, long long  B){
    if(A%B ==0) return B;
    else return gcd(B, A%B);
}

int main(void){
    long long A, B;
    cin >> A >> B;

    long long max = 0;

    if(A>=B){
        max = gcd(A,B);
    }else{
        max = gcd(B,A);
    }


    for(long long i = 0; i<max; i++){
        cout << "1";
    }
}