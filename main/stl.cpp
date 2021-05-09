#include<iostream>
#include<stdexcept>
#include<string>
#include<cstdlib>
#include<cstdio>
#include<ctime>
#include<list>
#include<set>
#include<algorithm>
#include<ext\array_allocator.h>
#include<ext\mt_allocator.h>
#include<ext\debug_allocator.h>
#include<ext\pool_allocator.h>
#include<ext\bitmap_allocator.h>
#include<ext\malloc_allocator.h>
#include<ext\new_allocator.h>
using namespace std;

int allocators()
{
    list<string, allocator<string>> c;
    list<string, __gnu_cxx::malloc_allocator<string>> c2;
    list<string, __gnu_cxx::new_allocator<string>> c3;
    list<string, __gnu_cxx::__pool_alloc<string>> c4;
    list<string, __gnu_cxx::__mt_alloc<string>> c5;
    list<string, __gnu_cxx::bitmap_allocator<string>> c6;
    int ch;
    long value;
	cout<< "select: "<<endl
		<< "(1) std::allocator"
	    << "(2) malloc_allocator"
	    << "(3) new_allocator"
	    << "(4) __pool_alloc"
	    << "(5) __mt_alloc"
		<< "(6) bitmap_allocator";
    cin>>ch;
    if(ch!=0){
        cout<<"number:";
        cin>>value;
    }
    char buf[10];
    clock_t time=clock();
    for(int i=0;i<value;i++){
        try{
            snprintf(buf,10,"%d",i);
            switch(ch){
                case 1:
                    c.push_back(string(buf));
                    break;
                case 2:
                    c2.push_back(string(buf));
                    break;
                case 3:
                    c3.push_back(string(buf));
                    break;
                case 4:
                    c4.push_back(string(buf));
                    break;
                case 5:
                    c5.push_back(string(buf));
                    break;
                case 6:
                    c6.push_back(string(buf));
                    break;
                default:
                    break;
            }
        }catch(exception& e){
            cout<<i<<" "<<e.what()<<endl;
            abort();
        }
        cout<<"push_back time:"<<(clock()-time)<<endl;
        int* p;
        allocator<int> a;
        p= a.allocate(1);
        a.deallocate(p,1);
        __gnu_cxx::malloc_allocator<int> a2;
        p= a2.allocate(1);
        a2.deallocate(p,1);
        __gnu_cxx::malloc_allocator<int> a3;
        p= a3.allocate(1);
        a3.deallocate(p,1);
        __gnu_cxx::malloc_allocator<int> a4;
        p= a4.allocate(1);
        a4.deallocate(p,1);
        __gnu_cxx::malloc_allocator<int> a5;
        p= a5.allocate(1);
        a5.deallocate(p,1);
        __gnu_cxx::malloc_allocator<int> a6;
        p= a6.allocate(1);
        a6.deallocate(p,1);
    }
    return 0;
}

int rb_trees()
{
    _Rb_tree<int,int,_Identity<int>,less<int>> itree;
    itree._M_insert_unique(1);
    itree._M_insert_unique(2);
    itree._M_insert_unique(3);
    itree._M_insert_unique(4);
    itree._M_insert_unique(5);
    cout<<itree.empty()<<endl;
    cout<<itree.size()<<" "<<itree.count(2)<<endl;
    itree._M_insert_equal(2);
    itree._M_insert_equal(2);
    cout<<itree.size()<<" "<<itree.count(2)<<endl;
    return 0;
}
