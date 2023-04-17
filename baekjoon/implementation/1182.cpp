#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> sumA;
vector<int> sumB;

vector<int> A;
vector<int> B;

int main() {
    int N, S;

    cin >> N >> S;

    for(int i=0; i<N; i++){
        int num;
        cin >> num;

        if(i <= N/2){
            A.push_back(num);
        }else{
            B.push_back(num);
        }
    }    

    for(int i=0; i< (1<<A.size()); i++){
        int sum = 0;
        for(int k=0; k<A.size(); k++){
            if(i & (1 << k)){
                sum += A[k];
            }
        }
        sumA.push_back(sum);
    }

    for(int i=0; i< (1<<B.size()); i++){
        int sum = 0;
        for(int k=0; k<B.size(); k++){
            if(i & (1 << k)){
                sum += B[k];
            }
        }
        sumB.push_back(sum);
    }

    long long result = 0;
    
    sort(sumA.begin(), sumA.end());
    sort(sumB.begin(), sumB.end());   

    for(int i=0; i<sumA.size(); i++){
        int target = S - sumA[i];
        result += upper_bound(sumB.begin(), sumB.end(), target) - lower_bound(sumB.begin(), sumB.end(), target);
    }

    if(S == 0){
        result -= 1;
    }
    
    cout << result;
}