//#include <sys/typed.h>
#include <dirent.h>
#include <iostream>
#include "input.h"
#include "errno.h"
vector<string> completions(char* typed,vector<string> unfiltered){
  //opens the file ones
  //assumes it has not been upgraded unless notified
  vector<string> filtered = vector<string>();
  int i;
  cout<<"looking for "<<typed<<endl;
  for(i=0;i<unfiltered.size();i++)
    {
      if(unfiltered[i].find(typed)!=-1)
	{
	  filtered.push_back(unfiltered[i]);
	   cout<<unfiltered[i]<<endl;
	}
    }
  return filtered;
}

int getdir (string dir, vector<string> &files)
{
  DIR *dp;
  struct dirent *dirp;
  if((dp = opendir(dir.c_str())) == NULL) {
    cout << "Error(" << errno << ") opening " << dir << endl;
    return errno;
  }

  while ((dirp = readdir(dp)) != NULL) {
    files.push_back(string(dirp->d_name));
  }
  closedir(dp);
  return 0;
}

int main(int argc,char** argv)
{
  vector<string> allfiles = vector<string>();
  string dir=".";
  getdir(dir,allfiles);
  while(true)
    {
      cout<< ">";
      char typed[256];
      cin.getline(typed,256);
      completions(typed,allfiles);
    }
}
