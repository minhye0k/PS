#include <iostream>
#define fastio cin.tie(0) -> sync_with_stdio(0)

using namespace std;

char result[3072][6143];

void draw(int row, int col) {
    result[row][col] = '*';
    
    result[row+1][col-1] = '*';
    result[row+1][col+1] = '*';

    for(int i=0; i<5; i++){
        result[row+2][col-2+i] = '*';
    }
}

void triangle(int n, int row, int col){
    if(n == 3){
        draw(row,col);
        return;
    }

    triangle(n/2, row, col);
    triangle(n/2, row + n/2, col - n/2);
    triangle(n/2, row + n/2, col + n/2);
}

int main(void) {
    fastio;

    int N;
    cin >> N;

    for (int i=0; i<N; i++) {
        for (int j=0; j<2*N-1; j++){
            result[i][j] = ' ';
        }
    }

    triangle(N,0,N-1);

    for (int i=0; i<N; i++) {
        for (int j=0; j<2*N-1; j++){
            cout << result[i][j];
        }
        cout << '\n';
    }


}