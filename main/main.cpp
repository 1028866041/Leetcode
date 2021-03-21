#include"tank.h"
#include"ptr.h"
#include<iostream>
#include<limits>
#include<string>
using namespace std;

extern int conts();
extern int rb_trees();

int main(int argc, char **argv) {
    cout<<__cplusplus<<endl;
    conts();
    //allocators();
    rb_trees();

    auto_ptr<int> p(new int(1));
    auto_ptr<int> q;
    cout<<p<<":"<<q<<endl;
    *p+=2;
    q=p;
    cout<<p<<":"<<q<<endl;
    cout<<numeric_limits<string>::is_specialized<<endl;

    Tank t1('a');
    cout<<t1.getCount()<<endl;
    Tank *pq=new Tank('b');
    cout<<Tank::getCount()<<endl;
    Tank *qp=new Tank('c');
    cout<<qp->getCount()<<endl;
    delete pq;
    delete qp;
    cout<<Tank::getCount()<<endl;
    system("pause");
    return 0;
}
