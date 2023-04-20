#include <iostream>
#include <algorithm>

using namespace std;

int N, M;
int rectangle[50][50];

long long ans = 0;

long long sumOfRectangle(int x1, int x2, int y1, int y2) {
    long long ret = 0;
    for(int i=y1; i<y2; i++) {
        for(int j=x1; j<x2; j++) {
            ret += rectangle[i][j];
        }
    }

    return ret;
}

int main() {

    cin >> N >> M;

    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            scanf("%1d", &rectangle[i][j]);
        }
    }

    long long sumOfMul = 0;

    for (int i=1; (i<N-1 || i<M-1); i++) {
        for (int j=i+1; (j<N || j<M); j++) {
            if (i < M-1) {
                sumOfMul = sumOfRectangle(0, i, 0, N) * sumOfRectangle(i, j, 0, N) * sumOfRectangle(j, M, 0, N);
            }

            if (sumOfMul > ans) ans = sumOfMul;

            if (i < N-1) {
                sumOfMul = sumOfRectangle(0, M, 0, i) * sumOfRectangle(0, M, i, j) * sumOfRectangle(0, M, j, N);
            }

            if (sumOfMul > ans) ans = sumOfMul;
        }
    }

    for(int i=1; i<M; i++){
        for(int j=1; j<N; j++){
            sumOfMul = sumOfRectangle(0, i, 0, N) * sumOfRectangle(i, M, 0, j) * sumOfRectangle(i, M, j, N);
            if (sumOfMul > ans) ans = sumOfMul;

            sumOfMul = sumOfRectangle(i, M, 0, N) * sumOfRectangle(0, i, 0, j) * sumOfRectangle(0, i, j, N);
            if (sumOfMul > ans) ans = sumOfMul;
        }
    }

    for(int i=1; i<N; i++){
        for(int j=1; j<M; j++){
            sumOfMul = sumOfRectangle(0, M, 0, i) * sumOfRectangle(0, j, i, N) * sumOfRectangle(j, M, i, N);
            if (sumOfMul > ans) ans = sumOfMul;

            sumOfMul = sumOfRectangle(0, M, i, N) * sumOfRectangle(0, j, 0, i) * sumOfRectangle(j, M, 0, i);
            if (sumOfMul > ans) ans = sumOfMul;
        }
    }

    cout << ans;

}