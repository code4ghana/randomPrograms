import random

def swap(arr,a,b):
    print "swapping %i and %i"%(a,b) 
    temp=arr[a]
    arr[a]=arr[b]
    arr[b]=temp

def randomPartition(arr,start,end):
    swap(arr,start,random.randint(start,end))
    partition(arr,start,end)
    
def partition(arr,start,end):
    v=arr[start]
    h=start
    for i in range(start,end):
        #if current value is to left of the pivot, make space for it
        if(arr[i]<v):
            h+=1
            swap(arr,h,i)
    swap(arr,h,start)
    return h

def quicksort(arr,start,end):
    print arr
    if(start<end):
        m=partition(arr,start,end)
        quicksort(arr,start,m)
        quicksort(arr,m+1,end)

    
mylist=[3,1,5,6,4,2,676,8,99,9,76,82,-1]
print mylist
quicksort(mylist,0,len(mylist))
print all(mylist[i]<mylist[i+1] for i in range(0,len(mylist)-1))
print mylist
