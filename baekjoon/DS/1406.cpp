#include <iostream>
#include <stack>

using namespace std;

int main(void){
    stack<char> right;
    stack<char> left;

    string s;
    cin >> s;
    int size = s.length();

    for(int i=0; i<size; i++){
        left.push(s[i]);
    }

    char command;

    int M;

    cin >> M;

    for(int i=0; i<M; i++){
        cin >> command;
        if(command == 'L'){
            if(!left.empty()){
                char leftCh = left.top();
                left.pop();
                right.push(leftCh);
            }
        }else if(command == 'D'){
            if(!right.empty()){
                char rightCh = right.top();
                right.pop();
                left.push(rightCh);
            }

        }else if(command == 'B'){
            if(!left.empty()){
                left.pop();
            }
        }else if(command == 'P'){
            char ch;
            cin >> ch;

            left.push(ch);
        }
    }

    while(!left.empty()){
        char leftCh = left.top();
        right.push(leftCh);
        left.pop();
    }

    while(!right.empty()){
        cout << right.top();
        right.pop();
    }
}