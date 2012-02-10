#include "TreeOps.h"
//---------------------------BST---TEST-------------------//
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
//---------------------------------------//


//---------------hybrid dfs/bfs----------------//
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

//----------find element using hybrid-------------// 
void find(BinTree_t* root,int find)
{
  int found=0;
  int depth=1;
  while(found==0)
    {
    found=descendBy(root,find,depth++);
    }
  printf("The tree %s%i\n",(found==1)?"contains ":"does not contain ",find);
}

//-----------------Visits------------------------//
void inOrderVisit(BinTree_t* node,void (*visit)(int))
{
  if(node==NULL)
    {
      return;
    }
  inOrderVisit(node->left,visit);
  visit(node->value);
  inOrderVisit(node->right,visit);
}

void postOrderVisit(BinTree_t* node,void (*visit)(int))
{
  if(node==NULL)
    {
      return;
    }
  postOrderVisit(node->left,visit);
  postOrderVisit(node->right,visit);
  visit(node->value);
}

void preOrderVisit(BinTree_t* node,void (*visit)(int))
{
  if(node==NULL)
    {
      return;
    }
  visit(node->value);
  preOrderVisit(node->left,visit);
  preOrderVisit(node->right,visit);

}

//--------------------------------------------------//


//-------------------descend to level--------------------//
int goToLevel(BinTree_t* node,int level,void (*visit)(int))
{
 
  if(node==NULL)
    {//not  found
      return 0;
    }
  if(level==0)
    {
      visit(node->value);
      return 1;
    }
  int checkLeft = goToLevel(node->left,level-1,visit);
  int checkRight = goToLevel(node->right,level-1,visit);
  //dead end?
  return (checkLeft==1 || checkRight==1);
}

void level_visit(BinTree_t* root,void (*visit)(int))
{
  int i=0;
  while(goToLevel(root,i++,visit)){}
}


//------------------insert---------------//
void insert(BinTree_t* node,int val)
{
  if(node==NULL)
    {
      node=malloc(sizeof(BinTree_t));
      node->value=val;
      return;
    }
  if(val>=node->value)
    {
      insert(node->right,val);
    }
  if(val<node->value)
    {
      insert(node->left,val);
    }
}

BinTree_t* BSTFromSortedList(int vals[])
{
  BinTree_t* root;
  
}
BinTree_t* huffmanCoding(char[] word){
    BinTree_t* root;
    
}
