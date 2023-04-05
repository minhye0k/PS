#include <iostream>
#define fastio cin.tie(0) -> sync_with_stdio(0)

using namespace std;

int video[65][65];

bool check(int x, int y, int n){

    int first = video[y][x];

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(video[y+i][x+j] != first) return false;
        }
    }

    return true;
}

void divide(int x, int y, int n){
    bool isPiece = check(x,y,n);

    if(isPiece) {
        cout << video[y][x];
    } else {
        cout << "(";
        int nextN = n/2;
        for(int i=y; i<y+n; i+=nextN) {
            for(int j=x; j<x+n; j+=nextN) {
                divide(j,i,nextN);
            }
        }
        cout << ")";
    }

}

int main(){
    fastio;

    int N;

    scanf("%d", &N);

    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            scanf("%1d", &video[i][j]);
        }
    }

    divide(1,1,N);
}