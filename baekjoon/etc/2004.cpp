#include <iostream>

using namespace std;

long long getNumberOfTwo(int num){
    long long numberOfTwo = 0;
    for(long long i=2; i<=num; i*=2){
        numberOfTwo += num/i;
    }
    return numberOfTwo;
}

long long getNumberOfFive(int num){
    long long numberOfFive = 0;
    for(long long i=5; i<=num; i*=5){
        numberOfFive += num/i;
    }
    return numberOfFive;
}

int main(void){
    int N, M;

    cin >> N >> M;

    long long numberOfTwo = 0;
    long long numberOfFive = 0;

    numberOfTwo += getNumberOfTwo(N);
    numberOfTwo -= getNumberOfTwo(N-M);
    numberOfTwo -= getNumberOfTwo(M);

    numberOfFive += getNumberOfFive(N);
    numberOfFive -= getNumberOfFive(N-M);
    numberOfFive -= getNumberOfFive(M);

    cout << (numberOfTwo >= numberOfFive ? numberOfFive : numberOfTwo);
}