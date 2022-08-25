#include <iostream>
#include <vector>

using namespace std;

int main(void){
    
    int n;
    cin >> n;

    vector<long> d(n+1, 0);

    d[2] = 3;
    d[0] = 1;
    for(int i=4; i<=n; i++){
        if(!(i%2 == 0)){
            d[i] = 0;
        }else{
            d[i] = d[i-2] * 3;
            for(int j=4; j<=i; j+=2){
                d[i] += d[i-j]*2;
            }
        }
    }

    cout << d[n] << '\n';
}