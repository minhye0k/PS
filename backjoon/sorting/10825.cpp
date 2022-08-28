#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Student{
    string name;
    int korean;
    int english;
    int math;
};

bool compare(Student u, Student v){
    if(u.korean == v.korean && u.math == v.math && u.english == v.english) return u.name < v.name;
    else if(u.english == v.english && u.korean == v.korean) return u.math > v.math;
    else if(u.korean == v.korean) return u.english < v.english;

    return u.korean > v.korean;
}

int main(void){
    int N;
    cin >> N;

    vector<Student> v(N);

    for(int i=0; i<N; i++){
        Student student;
        cin >> student.name >> student.korean >> student.english >> student.math;
        v.push_back(student);

    }

    sort(v.begin(), v.end(), compare);

    for(Student student : v){
        cout << student.name << '\n';
    }
}