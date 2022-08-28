#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int,string> u, pair<int,string>v){
    return u.first < v.first;
}

int main(void){
    
    int N;
    cin >> N;
    
    vector<pair<int,string> > ageAndName(N);

    for(int i=0; i<N; i++){
        cin>>ageAndName[i].first >> ageAndName[i].second;
    }

    stable_sort(ageAndName.begin(), ageAndName.end(), compare);

    for(int i=0; i<N; i++){
        cout << ageAndName[i].first << " " << ageAndName[i].second << '\n';
    }
}