#include <iostream>

using namespace std;

void checkBlank(int x, int y, int n){
    if(n == 1){
        cout << '*';
    }else if((x / (n/3) % 3) == 1 && (y / (n/3) % 3) == 1){
        cout << ' ';
    }else{
        checkBlank(x,y,n/3);
    }
}

int main(void){
    int N;

    cin >> N;

    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            checkBlank(j,i, N);
        }
        cout << '\n';
    }
}