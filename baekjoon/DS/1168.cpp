#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

int init(vector<int> &segment, int node, int s, int e){
    if(s == e) return segment[node] = 1;
    int mid = (s+e) /2;
    return segment[node] = init(segment, node * 2, s, mid) + init(segment, 2 * node+ 1, mid+1, e);
}

int query(vector<int> &segment, int node, int s, int e, int order){
    if(s == e) return s;
    int mid = (s+e) /2;
    if(order <= segment[node * 2]) return query(segment, node*2, s, mid, order);
    else return query(segment, 2*node+1, mid+1, e, order - segment[node*2]);
}

int update(vector<int> &segment, int node, int s, int e, int del){
    segment[node]--;
    if(s==e) return 0;
    int mid = (s+e)/2;
    if(del<=mid) return update(segment, node*2, s, mid, del);
    else return update(segment, 2*node+1, mid+1, e, del);
}

int main(void){
    int N, K;
    cin >> N >> K;

    int h = log2(N) + 1;
    int size = 2 << h;

    vector<int> segment(size+1, 0);

    init(segment, 1, 1, N);

    cout << "<";

    int index = 1;

    for(int i = 0; i<N; i++){
        int remainingNumberOfPerson = N-i;
        index = index + K - 1;

        if(index % remainingNumberOfPerson == 0) index = remainingNumberOfPerson;
        else if(index > remainingNumberOfPerson) index = index % remainingNumberOfPerson;

        int num = query(segment, 1, 1, N, index);

        update(segment, 1, 1, N, num);

        if(i == N-1) cout << num;
        else cout << num << ", ";

    }

    cout << '>';
}