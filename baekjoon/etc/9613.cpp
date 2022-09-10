#include <iostream>

using namespace std;

int gcd(int a, int b){
    if(a%b == 0 ) return b;
    else return gcd(b, a%b);
}

int main(void){
    int t;
    cin >> t;

    for(int i=0; i<t; i++){
        int n;
        cin >> n;
        long long result = 0;
        int arr[n];
        for(int j=0; j<n; j++){
            cin >> arr[j];
        }

        for(int j=0; j<n; j++){
            for(int k=j+1; k<n; k++){
                if(arr[j] >= arr[k]){
                    result += gcd(arr[j], arr[k]);
                }else{
                    result += gcd(arr[k], arr[j]);
                }
            }
        }

        cout << result << '\n';
    }
}