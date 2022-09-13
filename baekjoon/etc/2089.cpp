#include <iostream>
#include <stack>
using namespace std;

int main(void){
    int N;
    cin >> N;

    stack<int> binary;

    if(N==0){
        cout << '0';
    }

    while(N!=0){
        if(N%-2 == 0){
            binary.push(0);
            N /= (-2);
        }else{
            binary.push(1);
            N = (N-1) / -2;
        }
    }

    while(!binary.empty()){
        cout << binary.top();
        binary.pop();
    }
}