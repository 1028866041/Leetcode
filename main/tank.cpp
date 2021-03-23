#include"tank.h"
#include<iostream>
using namespace std;

int Tank::count=0;
Tank::Tank(char c)
{
    code= c;
    count++;
    cout<<"tank"<<endl;
}

Tank::~Tank()
{
    count--;
    cout<<"~tank"<<endl;
}

void Tank::fire()
{
    getCount();
    cout<<"fire"<<endl;
}

int Tank::getCount()
{
    return count;
}

int tank()
{
    Tank t1('a');
    cout<<t1.getCount()<<endl;
    Tank *pq=new Tank('b');
    cout<<Tank::getCount()<<endl;
    Tank *qp=new Tank('c');
    cout<<qp->getCount()<<endl;
    delete pq;
    delete qp;
    cout<<Tank::getCount()<<endl;
    return 0;
}
