#include <iostream>
#include <vector>

using namespace std;

int main(void){
    string code;
    getline(cin, code);

    int size = code.size();

    if(code.at(0) == '0'){
        cout<< 0 << '\n';
        return 0;
    }
    vector<long> d(size+1,0);
    vector<long> c(size+1,0);
    d[0] = 1;
    d[1] = 1;

    for(int i=1; i<=size; i++){
        c[i] = code.at(i-1) - '0';
    }

    for(int i=2; i<=size; i++){
        if(c[i]>0){
            d[i] = d[i-1] % 1000000;
            if(c[i-1]>0){
                if(c[i-1]==1 && c[i] > 0){
                    d[i] = (d[i] +d[i-2]) % 1000000;
                }else if(c[i-1]==2 && c[i] <=6){
                    d[i] = (d[i] +d[i-2]) % 1000000;
                }
            }
        } else{
            if(c[i-1] > 0 && c[i-1]<=2){
                d[i] = d[i-2] % 1000000;
            }
        }
    }

    cout << d[size] % 1000000<< '\n';

}