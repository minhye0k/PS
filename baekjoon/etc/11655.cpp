#include <iostream>

using namespace std;

int main(void){
    string s;
    getline(cin, s);

    int size = s.length();

    for(int i=0; i<size; i++){
        char ch = s.at(i);
        if('A' <= ch && ch <= 'Z'){
            if(ch + 13 > 'Z'){
                int dif = 13 - ('Z' - ch);

                s[i] = 'A' + dif - 1;
            }else{
                s[i] = ch + 13;
            }
        }else if('a' <= ch && ch <= 'z'){
            if(ch + 13 > 'z'){
                int dif = 13 - ('z' - ch);
                s[i] = 'a' + dif - 1;
            }else{
                s[i] = ch+13;
            }
        }
    }

    cout << s << '\n';
}