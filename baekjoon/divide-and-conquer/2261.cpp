#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

#define MAX 800000000

vector<pair<int, int>> v;

int power(int x){
    return pow(x, 2);
}

int distance(pair<int, int> p1, pair<int, int> p2) {
    return power(p1.first - p2.first) + power(p1.second - p2.second);
}

bool compareY(pair<int, int> p1, pair<int, int> p2){
    return p1.second < p2.second;
}

int search(int low, int high){
    if(low == high) return MAX;
    if(low == high - 1) return distance(v[low], v[high]);

    int mid = (low + high) / 2;
    int lmin = search(low, mid);
    int rmin = search(mid+1, high);

    int minimum = min(lmin, rmin);

    vector<pair<int, int>> vv;

    int midx = v[mid].first;

    for(int i=low; i<=high; i++){
        int xdiffSquared = power(midx - v[i].first);
        if(xdiffSquared < minimum) vv.push_back(v[i]);
    }

    sort(vv.begin(), vv.end(), compareY);

    int size = vv.size();

    for(int i=0; i < size - 1; i++) {
        for(int j=i+1; j<size; j++) {
            int ydiff = vv[i].second - vv[j].second;

            if(power(ydiff) >= minimum) break;
            minimum = min(distance(vv[i], vv[j]), minimum);
        }
    }    

    return minimum;
}

int main(){
    int N;
    cin >> N;

    for(int i=0; i<N; i++){
        int x, y;
        cin >> x >> y;
        v.push_back({x, y});
    }

    sort(v.begin(), v.end());

    cout << search(0, N-1);
}