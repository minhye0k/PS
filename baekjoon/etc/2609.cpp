#include <iostream>

using namespace std;

int gcd(int a, int b){
    if(a%b == 0) return b;
    else return gcd(b,a%b);
}

int main(void){
    int A, B;
    cin >> A >> B;

    int maximum = 0;

    if(A>=B){
        maximum = gcd(A,B);
    }else{
        maximum = gcd(B,A);
    }

    cout << maximum << '\n';
    cout << (A*B)/maximum;


}