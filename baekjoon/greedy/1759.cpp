#include <bits/stdc++.h>

using namespace std;

string password;

bool visited[15];

string vawel = "aeiou";

int L, C;

bool check(string s){
    int vawelCount = 0;
    int consonantCount = 0;

    for(char a : s){
        if(vawel.find(a) != string::npos) vawelCount++;
        else if('a' < a && a <= 'z') consonantCount++;

        if(vawelCount >= 1 && consonantCount >=2) return true;
    }

    return false;
}

void dfs(string s, int index){
    int size = s.size();
    if(size == L){
        if(check(s)) cout << s << '\n';
        return;
    }

    for(int i=index; i<C; i++){
        if(C - index < L-size) break;
        if(!visited[i]){
            visited[i] = true;
            dfs(s + password[i], i);
            visited[i] = false;
        }
    }
}

int main() {
    cin >> L >> C;

    for(int i=0; i<C; i++){
        char c;
        cin >> c;
        password += c;
    }

    sort(password.begin(), password.end());

    for(int i=0; i<=C-L; i++){
        string s(1,password[i]);
        visited[i] = true;
        dfs(s, i);
        visited[i] = false;
    }

}