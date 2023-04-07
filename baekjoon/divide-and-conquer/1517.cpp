#include <iostream>
#define fastio cin.tie(0) -> sync_with_stdio(0)
using namespace std;


int num[500000];
int sortedNum[500000];
int N;

long long answer = 0;

void merge(int start, int end) {
    int mid = (start + end) / 2;
    int left = start;
    int right = mid + 1;
    int current = start;

    while(left <= mid && right <= end) {
        if(num[left] <= num[right]){
            sortedNum[current++] = num[left++];
        }else{
            sortedNum[current++] = num[right++];
            answer += mid + 1 - left;
        }
    }

    if(right > end){
        while (left <= mid){
            sortedNum[current++] = num[left++];
        }
    } else {
        while(right<=end){
            sortedNum[current++] = num[right++];
        }
    }

    for(int i = start; i<=end; i++){
        num[i] = sortedNum[i];
    }
}

void partition(int start, int end){
    if(start == end){
        return;
    }

    int mid = (start + end) / 2;

    partition(start, mid);
    partition(mid + 1, end);
    merge(start, end);

}

int main(void) {
    fastio;

    cin >> N;

    for(int i=0; i<N; i++){
        cin >> num[i];
    }

    partition(0, N-1);

    cout << answer;
}