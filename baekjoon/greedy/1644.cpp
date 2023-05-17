#include <bits/stdc++.h>

using namespace std;

int main(){
    int answer = 0;

    int N;
    cin >> N;

    bool isPrime[N+1];
    memset(isPrime, true, sizeof(isPrime));

    isPrime[0] = isPrime[1] = false;

    vector<int> primeNumbers;

    for(int i=2; i*i<=N; i++){
        for(int j=i*i; j<=N; j+=i){
            isPrime[j] = false;
        }
    }

    for(int i=0; i<=N; i++){
        if(isPrime[i]){
            primeNumbers.push_back(i);
        }
    }

    int size = primeNumbers.size();

    int start = 0, end = 0;
    int sum = 0;
    
    while(start < size){
        if(sum >= N){
            sum -= primeNumbers[start];
            start++;
        }else if(end >= size){
            break;
        }else if(sum < N){
            sum += primeNumbers[end];
            end++;
        }

        if(sum == N){
            answer++;
        }
    }

    cout << answer;

}