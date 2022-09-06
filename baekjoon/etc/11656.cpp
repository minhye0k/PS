#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void){
    string S;
    cin >> S;

    int size = S.length();

    vector<string> v(size);

    for(int i=0; i<size; i++){
        v[i] = S.substr(i);
    }

    sort(v.begin(), v.end());

    for(int i=0; i<size; i++){
        cout << v[i] << '\n';
    }
}