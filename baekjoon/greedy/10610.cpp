#include <bits/stdc++.h>

using namespace std;

string N;

bool compare(char a, char b){
    return a > b;
}

int main(){
    
    cin >> N;

    vector<int> v;
    long long sum = 0;
    bool possible = false;

    for(char c : N){
        sum += c - '0';
        if (c - '0' == 0) possible = true;
    }

    if(!possible || sum %3 !=0){
        cout << -1;
        return 0;
    }
    
    sort(N.begin(), N.end(), compare);

    cout << N;

    return 0;

}