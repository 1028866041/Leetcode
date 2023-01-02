#include<boost/lambda/lambda.hpp>
#include<iostream>
#include<iterator>
#include<algorithm>

using namespace boost::lambda;

int iter(int argc, char *argv[])
{
    typedef std::istream_iterator<int> in;
    std::for_each(in(std::cin), in(), std::cout<<(_1*3)<<" ");
    return 0;
}