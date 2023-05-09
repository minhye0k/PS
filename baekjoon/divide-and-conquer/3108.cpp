#include <bits/stdc++.h>

using namespace std;

int main(){
    string s;
    getline(cin, s);

    stringstream ss(s);

    string word;
    vector<string> words;
    while(getline(ss, word, ' ')){
        words.push_back(word);
    }

    cout << words.size();
}