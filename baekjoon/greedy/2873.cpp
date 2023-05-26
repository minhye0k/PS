#include <bits/stdc++.h>

using namespace std;


int main() {

    pair<int, int> blocker;

    int R, C;
    cin >> R >> C;

    int min = 1001;

    for(int i=0; i<R; i++){
        for(int j=0; j<C; j++){
            int num;
            cin >> num;

            if((i+j)%2 == 1 && min > num){
                blocker.first = i;
                blocker.second = j;
                min = num;
            }
        }
    }

    string move = "";

    if(R%2 == 1){
        for(int i=0; i<R; i++) {
            for(int j=0; j<C-1; j++){
                if(i%2==0) move += "R";
                else move += "L";
            }
            if(i == R-1) break;
            move += "D";
        }
    }else if(C%2 == 1){
        for(int i=0; i<C; i++){
            for(int j=0; j<R-1; j++){
                if(i%2==0) move+= "D";
                else move += "U";
            }
            if(i == C-1) break;
            move += "R";
        }
    }else{
        int r, c;
        c = blocker.second;
        if(blocker.first % 2 == 1) r = blocker.first - 1;
        else r = blocker.first;

        for(int i=0; i<r; i++){
            for(int j=0; j<C-1; j++){
                if(i%2==0) move += "R";
                else move += "L";
            }
            move += "D";
        }

        for(int i=0; i<c; i++){
            if(i%2==0) move += "DR";
            else move += "UR";
        }

        for(int i=c; i<C-1; i++){
            if(i%2==0) move += "RD";
            else move += "RU";
        }

        for(int i=r+2; i< R;i++){
            move += "D";
            for(int j=0; j< C-1; j++){
                if(i%2 == 0) move += "L";
                else move += "R";
            }
        }

    }

    cout << move;

    
}