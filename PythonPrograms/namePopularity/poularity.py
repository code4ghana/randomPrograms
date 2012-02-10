#Jeff Kusi
#This program uses regular expressions to get baby names from a file and outputs them in tems of popularity

import re,sys

def getNames(filename,outfile=0):
    file=open(filename,"r")
    text=file.read();
    #year=re.search(r'<h2>Popularity in\s+ \d+<\h2>',text)
    year=re.search(r'<caption><h2>Popularity\s+\w\w\s+(\d\d\d\d)',text)
    if(outfile==0):
        if(year):
            print year.group(1)



        names=re.findall(r'<td>(\d+)</td>\s<td>(\w+)</td>\s<td>(\w+)</td>',text)
        if(names):

            for i in names:
                print i[0], " ",i[1]," ",i[2]
    else:
        outfile=open(outfile,"w")
        if(year):
            outfile.writelines(year.group(1)+"\n")
             

        names=re.findall(r'<td>(\d+)</td>\s<td>(\w+)</td>\s<td>(\w+)</td>',text)
        if(names):
            for i in names:
                outfile.write(i[0]+" "+i[1]+" "+i[2]+"\n")


def main():
    if(len(sys.argv)<2):
        print "supply file name"
        exit();
    filename=sys.argv[1]
    output=0
    if(len(sys.argv)>2):
        output=sys.argv[2]
    
    
    getNames(filename,output)

if __name__=='__main__':
    main()
