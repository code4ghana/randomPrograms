#include "BinTree.h"

#ifndef HYBRID_BFS_DFS_H
#define HYBRID_BFS_DFS_H
int descendBy(BinTree_t* root,int find,int dept);
void find(BinTree_t* root,int(*compreTo)(const void*, const void *));
#endif
