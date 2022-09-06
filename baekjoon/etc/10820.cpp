#include <iostream>

using namespace std;

int main(void){
    string s;

    

    while(getline(cin,s)){
        int lower = 0;
        int upper = 0;
        int space = 0;
        int number = 0;

        int size = s.length();

        for(int i=0; i<size; i++){
            char ch = s.at(i);
            if('a' <= ch && ch <= 'z'){
                lower++;
            }else if('A' <= ch && ch <= 'Z'){
                upper++;
            }else if(ch == ' '){
                space++;
            }else if('0' <= ch && ch <= '9'){
                number++;
            }

        }
        cout << lower << ' ' << upper << ' ' << number << ' ' << space << '\n';

    }
}