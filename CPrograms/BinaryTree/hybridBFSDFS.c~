#include <stdio.h>
#include "hybridBFSDFS.h"


void find(BinTree_t* root,int find)
{
  int found=0;
  int depth=1;
  while(found==0){
    found=descendBy(root,find,depth++);
  }
  printf("The tree %s%i\n",(found==1)?"contains ":"does not contain ",find);
}

int descendBy(BinTree_t* root, int find,int dept)
{
  if(root==NULL)
    {//not  found
      return -1;
    }
  if(root->value==find)
    {
      return 1;
    }
  if(dept==0)
    {
      return 0;
    }
 int checkLeft= descendBy(root->left,find,dept-1);
 int checkRight=descendBy(root->right,find,dept-1);
 //dead end
 if(checkLeft==checkRight && checkLeft==-1)
   {
     return -1;
   }
 return (checkLeft==1 || checkRight==1);
}
