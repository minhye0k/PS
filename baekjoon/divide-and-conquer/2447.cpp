#include <iostream>

using namespace std;

void makeStar(){
    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            if(i==1 && i==j) cout << ' ';
            else cout << '*';
        }
        cout << '\n';
    }
}

void divide(int n){
    int nextN = n/3;
    
    if (nextN == 1) {
        return;
    }

    makeStar();

    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            if(i==1 && i==j) continue;
            divide(nextN);
        }
        cout<< '\n';
    }

}

int main(void){
    int N;

    cin >> N;

    makeStar(N);
}