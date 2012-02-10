#include <limits.h>
#include <stdio.h>
#include "BinTree.h"

#ifndef IS_BST_H
#define IS_BST_H
int isBSTHelp(BinTree_t* node,int min,int max);
void isBST(BinTree_t* root);
#endif
