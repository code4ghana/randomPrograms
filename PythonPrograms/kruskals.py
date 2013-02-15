class DisjointSets:
    def __init__(self):
        self.parent={}
        self.rank={}
        
    def makeset(self,i):
        self.parent[i]=i
        self.rank[i]=0

    def findset(self,i):
        root=i
        while(root!=self.parent[root]):
            root=self.parent[root]
        j=self.parent[i]
        while(j!=root):
            self.parent[i]=root
            i=j
            j=self.parent[i]
        return root

    def mergetrees(self,i,j):
        if(self.rank[i]<self.rank[j]):
            self.parent[i]=j
        elif(self.rank[i]>self.rank[j]):
            self.parent[j]=i
        else:
            self.parent[i]=j
            self.rank[j]=self.rank[j]+1

    def union(self,i,j):
        self.mergetrees(self.findset(i),self.findset(j))

    def print_aslist(self):
        print "length of parent is : ",len(self.parent)
        print "length of rank is : ",len(self.rank)
        for i,j in zip(self.parent,self.rank):
            print i,' ',j

        
    def print_astree(self):
        for i in range(len(self.rank)):
            for j,e in enumerate(self.rank):
                if self.rank[j]==i:
                    print self.parent[j]
    
        
class Edge:
    def __init__(self,vertex1,vertex2,w,tup=None):
        self.v1=tup[0] if tup else vertex1
        self.v2=tup[1] if tup else vertex2
        self.w=tup[2] if tup else w

def sort_by_weight(e1,e2):
    if e1[2]<e2[2]:
        return -1
    else:
        return 1


g1=[(1,2,4),(1,3,2),(1,5,3),(2,4,5),(3,4,1),(3,5,6),(3,6,3),(4,6,6),(5,6,2)]

def myprint(l):
    for e in l:
        print e,
    print
    

def kruskals(graph,n):
    graph.sort(sort_by_weight)
    myprint(graph)
    
    components=DisjointSets()
    for i in range(1,n+1):
        components.makeset(i)
    count=0
    i=1
    components.print_aslist()
    while(count<n-1):
#        print "i is ",i, "count is ",count
        if(components.findset(graph[i][0]) != components.findset(graph[i][1])):
            print graph[i][0], "  ",graph[i][1]
            count+=1
            components.union(graph[i][0],graph[i][1])
        i+=1


        
kruskals(g1,len(g1))
