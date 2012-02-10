#include <limits.h>
#include "BinTree.h"
#include <stdio.h>

//test is a given binary tree is a binary search tree
//BST definition:
//for each node N:
//1: all nodes left subtree must be < N
//2: all nodes right subtree must be >N

int isBSTHelp(BinTree_t* node,int min,int max)
{
   //rules are vacuosly true for null tree
  if(node==NULL)
    {
      return 1;
    }
  //check current node
  int cur=(min<=node->value && max>=node->value);

  if(cur){
      //1:
    int left=isBSTHelp(node->left,min,node->value);
    //2:
    int right=isBSTHelp(node->right,node->value,max);
    return (left && right);
  }
  return 0;
}

void isBST(BinTree_t* root)
{
 
  int min=INT_MIN;
  int max=INT_MAX;
  int val=isBSTHelp(root,min,max);
  printf("The given tree is %s%s\n",val?"":"Not ","a BST");
}
