from OutsideLibrary.table_parser import TableParser
import Tkinter
import os
import tkFileDialog
import urllib2
def getTable():
    for i in range(1,3):
#        response=urllib2.urlopen("http://www.soundkeepers.com/GRE/print.php?n="+str(1)).read()
        response=urllib2.urlopen("http://www.soundkeepers.com/GRE/print.php?n=1").read()
        p=TableParser()
        p.feed(response)
#        make file
#        s=""+p.doc
#        s+=str(os.linesep)
#        print (s)
        
       
getTable()
