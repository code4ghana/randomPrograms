import fileinput,pdb
# num_sub_strings=fileinput.input().next()
# sub_strings=[[fileinput.input().next() ] for i in range(num_sub_strings)]
# num_queries=fileinput.input().next()
# queries=[fileinput.inpu().next() for i in range(num_queries)]


def lexo(sub):
    subs=[]
    bin_rep=len(sub)
    for i in xrange(len(sub)):
        chars=""
#        pdb.set_trace()
        for b in xrange(len(sub)):
            if (i&1<<b):
                chars+=sub[b]
        subs.append(chars)
    return subs
        
print lexo("abcdefgh")
