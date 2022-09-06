#include <iostream>
#include <string>

using namespace std;

int main(void){
    string A, B, C, D;
    cin >> A >> B >> C >> D;

    long aPlusB = stol(A+B);
    long cPlusD = stol(C+D);

    cout << aPlusB + cPlusD << '\n';
}