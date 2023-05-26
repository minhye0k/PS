#include <bits/stdc++.h>

using namespace std;

bool compare(int a, int b){
    return a > b;
}

int main() {
    int N;

    cin >> N;

    vector<int> positive;
    vector<int> negative;

    int zeroCount = 0;

    int answer = 0;


    for(int i=0; i<N; i++) {
        int num;
        cin >> num;
        if(num > 1) positive.push_back(num);
        else if (num == 1) answer++;
        else if(num < 0) negative.push_back(num);
        else zeroCount++;    
    }

    sort(positive.begin(), positive.end(), compare);
    sort(negative.begin(), negative.end());

    int positiveSize = positive.size();
    int negativeSize = negative.size();

    for(int i=0; i<positiveSize; i+=2){
        if(i == positiveSize -1) break;
        answer += positive[i] * positive[i+1];
    }

    if(positiveSize % 2 != 0) answer += positive.back();

    for(int i=0; i<negativeSize; i+=2){
        if(i == negativeSize -1) break;
        
        answer += negative[i] * negative[i+1];
    }

    if(negativeSize % 2 != 0){
        if(!zeroCount){
            answer += negative.back();
        }
    }

    cout << answer;
}