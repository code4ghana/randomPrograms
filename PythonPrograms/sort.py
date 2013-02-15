import random

def swap(l,i,j):
    temp=l[i]
    l[i]=l[j]
    l[j]=temp
    
def partition(l,i,j):
    val=l[i]
    h=i
    for k  in range(i+1,j+1):
        if l[k]<val:
            h=h+1
            swap(l,h,k)
    swap(l,i,h)
    return h

def random_partition(l,i,j):
    swap(l,i,random.randint(i,j))
    return partition(l,i,j)
    

def quicksort(l,i,j):
    if(i<j):
        print l[i:j]
        p=random_partition(l,i,j)
        print p
        quicksort(l,i,p-1)
        quicksort(l,p+1,j)


mylist=[3,1,5,6,4,2,676,8,99,9,76,82,-1]
quicksort(mylist,0,len(mylist)-1)
for i in mylist:
    print i,

def merge(l,i,m,j):
    p=i
    q=m+1
    r=i
    c=[]
