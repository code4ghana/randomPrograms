class MaxHeap:
    def __init__(self,keys):
        self.keys=[]
        self.into=[]
        self.outof=[]

    def heap_smallest(self):
        return self.keys[self.outof[0]]
    
    def siftdown(self,i):
        pass

    def delete(self):
        pass
    
    def insert(self,val):
        pass

    def heapify(self):
        pass

    def decrease(self,index,val):
        self.keys[index]=val
        child=self.into[index]
        parent=child/2
        while(parent >=1):
            if(self.keys[self.outof[p]]<=val):
                break
            self.outof[c]=self.outof[parent]
            self.into[self.outof[child]]=child
            #move p and c up
            child=parent
            parent=child/2
            
        self.outof[child]=i
        self.into[i]=child
            
        
            
    
class Keeper:
    def __init__(self,keys):
        self.keys={i:e for i,e enumerated(keys) }
        
    def delete(self,key):
        val=self.keys[key]
        self.keys.delete(key)
        
    def decrease(self,w,wgt):
        self.keys[w]=wgt
    def isin(self,w):
        return w in self.keys
    
    def keyval(self,w):
        return self.keys[w]


def prims(adj,start,parent):
    keys=[ -1 for in range(1,len(adj))]
    keys[start]=0
    parent=[]
    parent[start]=0
    h=Keeper(keys)
    for i in range(1,len(adj)):
        v=h.delete()
        ref=adj[v]
        
