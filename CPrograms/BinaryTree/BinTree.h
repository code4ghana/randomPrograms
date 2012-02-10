//Jeff Kusi --jak7v
#ifndef BIN_TREE_H
#define BIN_TREE_H
typedef struct BinTree BinTree_t;
struct BinTree{
  BinTree_t* left;
  BinTree_t* right;
  void* value;

};
#endif
