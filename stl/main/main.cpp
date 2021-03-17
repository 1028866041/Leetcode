#include "tank.h"
#include <iostream>
using namespace std;

int main(int argc, char *argv) {
    // TO TEST
    //cout<<Solution()<<endl;
    Tank t1('a');
    cout<<t1.getCount()<<endl;

    Tank *p=new Tank('b');
    cout<<Tank::getCount()<<endl;
    Tank *q=new Tank('c');
    cout<<q->getCount()<<endl;
    delete p;
    delete q;
    cout<<Tank::getCount()<<endl;

    system("pause");
    return 0;
}
