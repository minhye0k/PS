#include <iostream>
#include <vector>

using namespace std;

vector<vector<int> > v(26 , vector<int> (26, 0));


void preorder(int i){
    char ch = i + 'A';
    if ( ch == '.'){
        return;
    }

    cout << ch;
    preorder(v[i][0]);
    preorder(v[i][1]);
}

void inorder(int i){
    char ch = i + 'A';
    if ( ch == '.'){
        return;
    }

    inorder(v[i][0]);
    cout << ch;
    inorder(v[i][1]);
}

void postorder(int i){
    char ch = i + 'A';
    if ( ch == '.'){
        return;
    }

    postorder(v[i][0]);
    postorder(v[i][1]);
    cout << ch;
}

int main() {
    int N;
    cin >> N;

    for(int i=0; i<N; i++) {
        char A, B, C;

        cin >> A >> B >> C;


        int parent = A - 'A';

        int leftChild = B - 'A';
        int rightChild = C - 'A';

        
        v[parent][0] = leftChild;
        v[parent][1] = rightChild;
    }

    preorder(0);
    cout << endl;
    inorder(0);
    cout << endl;
    postorder(0);

    
}
