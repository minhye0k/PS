#include <iostream>
#include <stack>

using namespace std;

int main(void){
    int N, B;
    cin >> N >> B;
    
    stack<char> s;
    
    while(N!=0){
        int n = N%B;
        char ch = '0';
        if(n>=10){
            ch = 'A' + (n - 10);
        }else{
            ch = '0' + n;
        }
        s.push(ch);
        N /= B;
    }

    while(!s.empty()){
        cout << s.top();
        s.pop();
    }
}