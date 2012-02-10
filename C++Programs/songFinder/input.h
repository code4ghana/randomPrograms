
//@author Jeff Kusi

#include <vector>
#include <string>
#ifndef INPUT_H
#define INPUT_H
using namespace std;
vector<string> completions(char* typed,vector<string> unfiltered);
int getdir (string dir, vector<string> &files);
#endif
