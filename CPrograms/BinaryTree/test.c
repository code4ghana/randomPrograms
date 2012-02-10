#include <stdlib.h>
#include "TreeOps.h"

void print_visitor(int x)
{
  printf(" - %i",x);
}
int main(int argc,char** argv){
  BinTree_t* root=malloc(sizeof(BinTree_t));
  BinTree_t* l=malloc(sizeof(BinTree_t));
  BinTree_t* r=malloc(sizeof(BinTree_t));
  root->left=l;
  root->right=r;
  root->value=1;
  l->value=2;
  r->value=3;
  BinTree_t* ll=malloc(sizeof(BinTree_t));
  BinTree_t* lr=malloc(sizeof(BinTree_t));
  l->left=ll;
  l->right=lr;
  ll->value=4;
  lr->value=5;
  BinTree_t* rl=malloc(sizeof(BinTree_t));
  BinTree_t* rr=malloc(sizeof(BinTree_t));
  r->left=rl;
  r->right=rr;
  rl->value=6;
  rr->value=7;
  
  isBST(root);
  find(root,10);
  printf("-------inOrder-----");
  inOrderVisit(root,&print_visitor);
  printf("\n");
  printf("-------postOrder-----");
  postOrderVisit(root,&print_visitor);
  printf("\n");
  printf("-------preOrder-----");
  preOrderVisit(root,&print_visitor);
  printf("\n");
  printf("-------print Level-----");
  level_visit(root,&print_visitor);
  printf("\n");
}
