#include <bits/stdc++.h>

using namespace std;

int a[10][10];

bool x[10][10];
bool y[10][10];
bool square[10][10];

int getSquareIndex(int x, int y){
    return (x/3)*3 + (y/3);
}

bool go(int z){
    if(z==81){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                cout << a[i][j] << " ";
            }
            cout << '\n';
        }

        return true;
    }

    int xx = z/9;
    int yy = z%9;

    if(a[xx][yy]){
        return go(z+1);
    }else{
        for(int i=1; i<=9; i++){
            if(!x[xx][i] && !y[yy][i] && !square[getSquareIndex(xx,yy)][i]){
                x[xx][i] = y[yy][i] = square[getSquareIndex(xx,yy)][i] = true;
                a[xx][yy] = i;
                if(go(z+1)){
                    return true;
                }
                x[xx][i] = y[yy][i] = square[getSquareIndex(xx,yy)][i] = false;
                a[xx][yy] = 0;
            }
        }
    }
    
    return false;
}

int main(){
    for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){
            cin >> a[i][j];
            if(a[i][j]){
                x[i][a[i][j]] = true;
                y[j][a[i][j]] = true;
                square[getSquareIndex(i,j)][a[i][j]] = true;
            }
        }
    }

    go(0);
    return 0;
}