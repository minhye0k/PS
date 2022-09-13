#include <iostream>
#include <cstring>

using namespace std;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    bool isPrime[1000001];
    memset(isPrime, true, sizeof(isPrime));

    isPrime[0] = isPrime[1] = false;

    for(int i=2; i*i<=1000000; i++){
        if(isPrime[i]){
            for(int j=i*i; j<=1000000; j+=i){
                isPrime[j] = false;
            }
        }
    }

    int n;
    while(true){
        cin >> n;
        if (n==0){
            return 0;
        }
        bool isSuccess = false;
        for(int i = n; i>= n/2; i--){
            if(isPrime[i]){
                if(isPrime[n-i]){
                    cout << n << " = " << n-i << " + " << i << '\n';
                    isSuccess = true;
                    break;
                }
            }

            
        }

        if(!isSuccess){
            cout << "Goldbach's conjecture is wrong.";
        }
    }
}