#include <iostream>
#include <fstream>
#include <cctype>
#include <cassert>
using namespace std;

int first(const string& line) {
    for (char c: line) {
        if (isdigit(c))
            return (c - '0') * 10;
    }
    assert (false);
    return -1;
}
int last(const string& line) {
    for (auto i = line.rbegin(); i != line.rend(); ++i)
    {
        if (isdigit(*i))
            return (*i) - '0';
    }
    assert (false);
    return -1;
}
int main()
{
    ifstream in("aoc-input1.txt");
    int sum = 0;
    string line;
    while (getline(in, line))
    {
        auto a = first(line), b = last(line);
        cout << line << ", a=" << a << ", b=" << b << endl;
        sum += (a + b);
    }
    cout << "sum = " << sum << endl;
    
}

