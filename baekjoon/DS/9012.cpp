#include <iostream>
#include <stack>

using namespace std;

int main(void){
    int N;
    cin >> N;

    for(int i=0; i<N; i++){
        string bracket;
        cin >> bracket;

        int size = bracket.length();

        stack<char> brackets;
        int sign = 0;

        if(bracket.at(0) != '('){
            cout << "NO\n";
            sign = 1;
        }else{
            brackets.push(bracket.at(0));
            for(int i=1; i<size; i++){
                if(bracket.at(i) == '('){
                    brackets.push(bracket.at(i));
                }else{
                    if(!brackets.empty()){
                        if(brackets.top() == '('){
                            brackets.pop();
                        }else{
                            cout << "NO\n";
                            sign = 1;
                            break;
                        }
                    }else{
                        cout << "NO\n";
                        sign = 1;
                        break;
                    }
                }
            }
        }
        if(sign == 1){
            continue;
        }

        if(brackets.empty()){
            cout << "YES\n";
        }else{
            cout << "NO\n";
        }
        
    }
}