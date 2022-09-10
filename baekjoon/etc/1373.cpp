#include <iostream>
#include <stack>

using namespace std;

int main(void){
    string s;
    cin >> s;

    stack<int> stack;

    int size = s.size();
    int index = size - 1;

    while (index >= 0) {
        int mul = 1;
        int result = 0;
        for(int i=0; i<3; i++){
            if(index-i<0) break;
            result += (s.at(index-i) - '0') * mul;
            mul = mul*2;
        }
        stack.push(result);


        index -= 3;
    }

    while(!stack.empty()){
        cout << stack.top();
        stack.pop();
    }
}