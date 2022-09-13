#include <iostream>
#include <stack>

using namespace std;

int main(void){
    stack<int> result;
    int A, B;
    int m;
    
    cin >> A >> B;
    cin >> m;

    int * arr= new int[m];

    for(int i=0; i<m; i++){
        cin >> arr[i];
    }

    int decimal = 0;
    int mul = 1;
    for(int i=0; i<m-1; i++){
        mul *= A;
    }

    for(int i=0; i<m; i++){
        decimal += mul*arr[i];
        mul /= A;
    }

    while (decimal>0){
        result.push(decimal % B);
        decimal /= B;
    }

    while(!result.empty()){
        cout << result.top() << " ";
        result.pop();
    }
}