#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int> & resultArr,vector<int> &arr, int left, int right){
    int mid = (left+right) /2;

    int i = left;
    int j = mid + 1;
    int k = left;

    while(i<=mid && j<=right){
        if(arr[i] <arr[j]){
            resultArr[k] = arr[i];
            i++;
        }else{
            resultArr[k] = arr[j];
            j++;
        }
        k++;
    }

    if(i > mid){
        while(j<=right){
            resultArr[k] = arr[j];
            j++;
            k++;
        }
    }else{
        while(i<=mid){
            resultArr[k] = arr[i];
            i++;
            k++;
        }
    }

    for (int i= left; i<=right; i++){
        arr[i] = resultArr[i];
    }

}

void partition(vector<int> & resultArr, vector<int> &arr, int left,int right){
    if(right>left){
        int mid = (left + right) /2;
        partition(resultArr, arr, left,mid);
        partition(resultArr, arr, mid+1,right);
        merge(resultArr, arr, left,right);
    }
}

int main(void){
    int N;
    cin >> N;

    
    vector<int> arr(N,0);
    vector<int> resultArr(N,0);

    for(int i=0; i<N; i++){
        cin >> arr[i];
    }
    

    partition(resultArr, arr,0, N-1);

    for(int i=0; i<N; i++){
        cout << arr[i] << '\n';
    }

}