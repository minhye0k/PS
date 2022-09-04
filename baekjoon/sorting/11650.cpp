#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int> &firstArr, vector<int> &secondArr, vector<int> &firstResultArr, vector<int> &secondResultArr
,int left, int right){
    int mid = (left+right)/2;
    int i = left;
    int j = mid +1;
    int k = left;

    while( i<=mid && j <= right){
        if(firstArr[i] < firstArr[j]){
            firstResultArr[k] = firstArr[i];
            secondResultArr[k] = secondArr[i];
            i++;
            k++;
        }else if(firstArr[i] == firstArr[j]){
            if(secondArr[i] < secondArr[j]){
                firstResultArr[k] = firstArr[i];
                secondResultArr[k] = secondArr[i];
                i++;
                k++;
            }else{
                firstResultArr[k] = firstArr[j];
                secondResultArr[k] = secondArr[j];
                j++;
                k++;
            }
        }else{
            firstResultArr[k] = firstArr[j];
            secondResultArr[k] = secondArr[j];
            j++;
            k++;
        }
    }

    if( i>mid){
        while(j<=right){
            firstResultArr[k] = firstArr[j];
            secondResultArr[k] = secondArr[j];
            j++;
            k++;
        }
    }else{
        while(i<=mid){
            firstResultArr[k] = firstArr[i];
            secondResultArr[k] = secondArr[i];
            i++;
            k++;
        }
    }

    for(int i=left; i<=right; i++){
        firstArr[i] = firstResultArr[i];
        secondArr[i] = secondResultArr[i];
    }
}


void partition(vector<int> &firstArr, vector<int> &secondArr, vector<int> &firstResultArr, vector<int> &secondResultArr
,int left, int right){
    if(right > left){
        int mid = (left+right)/2;
        partition(firstArr, secondArr, firstResultArr, secondResultArr, left,mid);
        partition(firstArr, secondArr, firstResultArr, secondResultArr, mid+1,right);
        merge(firstArr,secondArr,firstResultArr,secondResultArr, left,right);
    }
}

int main(void){
    int N;
    cin >> N;

    vector<int> firstArr(N, 0);
    vector<int> secondArr(N, 0);

    vector<int> firstResultArr(N, 0);
    vector<int> secondResultArr(N, 0);

    for(int i=0; i<N; i++){
        cin >> firstArr[i] >> secondArr[i];
    }

    partition(firstArr, secondArr, firstResultArr, secondResultArr, 0, N-1);

    for(int i=0; i<N; i++){
        cout << firstArr[i] << " " << secondArr[i] << '\n';
    }

}