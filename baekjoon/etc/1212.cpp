#include <iostream>
#include <stack>

using namespace std;

int main(void){
    string s;
    cin >> s;

    stack<int> stack;

    int size = s.length();
    if(size == 1 && s.at(0) == '0'){
        cout << '0';
    }

    for(int i=0; i<size; i++){
        int index = size -i -1;
        int n = s.at(index) - '0';
        int count = 3;
        while(n!=0 || (count != 0 && index!=0)){
            count--;
            stack.push(n%2);
            n/=2;
        }
    }

    while(!stack.empty()){
        cout << stack.top();
        stack.pop();
    }

}