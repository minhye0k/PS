#include <iostream>

using namespace std;

int main(){
    int E, S, M;

    cin >> E >> S >> M;

    int result = 1;

    int e = 1, s = 1, m = 1;

    while (true) {
        if(e==E && s==S && m==M) {
            break;
        }

        result++;
        e++; s++; m++;

        if(e == 16){
            e = 1;
        }

        if(s == 29){
            s = 1;
        }

        if(m == 20){
            m = 1;
        }

        
    }

    cout << result;
    

}