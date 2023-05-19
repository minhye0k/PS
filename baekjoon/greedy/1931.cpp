#include <bits/stdc++.h>

using namespace std;

bool compare(pair<int, int> a, pair<int, int> b){
    if(a.second == b.second) return a.first < b.first;
    else return a.second < b.second;
}

int main(){
    int N;
    cin >> N;

    vector<pair<int, int>> v;

    for(int i=0; i<N; i++){
        int start, end;

        cin >> start >> end;

        v.push_back({start, end});
    }

    sort(v.begin(), v.end(), compare);

    int answer = 1;

    int end = v[0].second;

    for(int i=1; i<N; i++) {
        if(v[i].first >= end){
            answer++;
            end = v[i].second;
        }
    }

    cout << answer;

}