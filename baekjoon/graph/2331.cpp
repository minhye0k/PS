#include <iostream>
#include <vector>

using namespace std;

int isVisited[236197];


int calculator(int A,int P){
    int result = 0;
    while(A!=0){
        int remainder = A%10;
        int num = 1;
        for(int i=0; i<P; i++){
             num *= remainder;
        }
        result += num;
        A = A/10;
    }

    return result;
}


void dfs(int start, int P){
    isVisited[start]++;
    if(isVisited[start] >2){
        return;
    }
    dfs(calculator(start, P), P);
}

int main(void){
    int A, P;

    cin >> A >> P;

    dfs(A,P);
    int count = 0;
    for(int i=0; i<236197; i++){
        if(isVisited[i] == 1){
            count++;
        }
    }
    cout << count << '\n';
}