#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main(void){
    string brackets;
    cin >> brackets;

    int size = brackets.length();

    stack<char> bracket;

    long result = 0;

    for (int i=0; i<size; i++){
        char bracketCharacter = brackets.at(i);
        if(bracketCharacter == '('){
            bracket.push(bracketCharacter);
        }else{
            if(bracket.empty()){
                continue;
            }else{
                if(i != 0){
                    char beforeBracket = brackets.at(i-1);
                    if(beforeBracket == '('){
                        bracket.pop();
                        result += bracket.size();
                    }else{
                        result += 1;
                        bracket.pop();
                    }
                }else{
                    continue;
                }
            }
        }
    }

    cout << result << '\n';
}