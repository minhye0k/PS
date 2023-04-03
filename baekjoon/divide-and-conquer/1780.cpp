#include <iostream>

#define fastio cin.tie(0)->sync_with_stdio(0)

using namespace std;

int result[3];

int paper[2188][2188];
int N;

bool check(int startX, int endX, int startY, int endY){
    int n = paper[startY][startX];

    for(int i=startY; i<=endY; i++){
        for(int j=startX; j<=endX; j++){
            if(paper[i][j] != n){
                return false;
            }
        }
    }

    return true;
}

void divide(int startX, int endX, int startY, int endY){
    bool haveToBeenCutted = check(startX, endX, startY, endY);

    if (haveToBeenCutted) {
        int n = paper[startY][startX];

        if (n == -1) {
            result[0]++;
        } else if(n == 0) {
            result[1]++;
        } else if(n == 1) {
            result[2]++;
        }
    }else { 
        int distance = (endY - startY + 1) / 3;
        for (int i = startY; i <= endY; i += distance) {
            for (int j = startX; j <= endX; j += distance) {

                divide(j, j + distance - 1, i, i + distance - 1);
            }
        }   
    }
} 

int main(){
    fastio;

    cin >> N;

    for(int i=1; i<=N; i++) {
        for(int j=1; j<=N; j++) {
            cin >> paper[i][j];
        }
    }

    divide(1, N, 1, N);

    for(int i=0; i<3; i++){
        cout << result[i] << '\n';
    }

}