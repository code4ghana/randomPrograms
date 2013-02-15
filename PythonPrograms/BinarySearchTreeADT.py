import sys

class Node:
    def __init__(self,val,left,right):
        self.val=val
        self.left=left
        self.right=right

    def left(self):
        return self.left

    def right(self):
        return self.right

    def __str__(self):
        return str(self.val)

nodes=[Node(i,None,None) for i in range(0,5)]

for i in range(0, len(nodes)):
    nodes[i].left=nodes[i*2+1] if i*2<len(nodes)-1 else None
    nodes[i].right=nodes[i*2+2] if i*2<len(nodes)-1 else None
    print nodes[i],"l: ",nodes[i].left,"r: ", nodes[i].right

#------------top sort------

class GraphNode:
    def __init__(self,val,ver):
        self.visited=False
        self.val=val
        self.ver=ver

    def __str__(self):
        return val;
    
nodes=[GraphNode("CS"+str(i),None) for i in range(100,600,50)]

def top_sort_recur(node):
    print node,
    for n in node.ver:
        if not n.visited:
            top_sort_recur(n)
    print
