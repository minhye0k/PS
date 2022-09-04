#include <iostream>

using namespace std;

struct Node {
    int value;
    Node * next;
    Node * prev;
};

class Deque{
    private:
        Node * tail;
        Node * head;
        int size;
    public:
        Deque(){
            tail = nullptr;
            head = nullptr;
            size = 0;
        }

        void push_front(int value){
            Node * node = new Node;
            node->value = value;
            if(size == 0){
                tail = node;
                head = node;
            }else{
                node -> next = head;
                head -> prev = node;
                head = node;
            }
            size++;
        }

        void push_back(int value){
            Node * node = new Node;
            node->value = value;
            if(size == 0){
                tail = node;
                head = node;
            }else{
                tail -> next = node;
                node -> prev = tail;
                tail = tail -> next;
            }
            size++;
        }

        void pop_front(){
            if(size == 0){
                cout << "-1\n";
            }else{
                cout << head -> value << '\n';
                head = head -> next;
                size--;
            }
        }

        void pop_back(){
            if(size == 0){
                cout << "-1\n";
            }else{
                cout << tail -> value << '\n';
                tail = tail -> prev;
                size--;
            }
        }

        void getSize(){
            cout << size << '\n';
        }

        void empty(){
            if(size == 0){
                cout <<"1\n";
            }else{
                cout << "0\n";
            }
        }

        void front(){
            if(size == 0){
                cout <<"-1\n";
            }else{
                cout << head -> value << '\n';
            }
        }

        void back(){
            if(size == 0){
                cout << "-1\n";
            }else{
                cout << tail -> value << '\n';
            }
        }       
};

int main(void){
    int N;
    cin >> N;

    Deque deque = Deque();

    for(int i=0; i<N; i++){
        string command;
        cin >> command;

        if(command == "push_front"){
            int N;
            cin >> N;
            deque.push_front(N);
        }else if(command == "push_back"){
            int N;
            cin >> N;
            deque.push_back(N);
        }else if(command == "pop_front"){
            deque.pop_front();
        }else if(command == "pop_back"){
            deque.pop_back();
        }else if(command == "size"){
            deque.getSize();
        }else if(command == "empty"){
            deque.empty();
        }else if(command == "front"){
            deque.front();
        }else if(command == "back"){
            deque.back();
        }
    }
}