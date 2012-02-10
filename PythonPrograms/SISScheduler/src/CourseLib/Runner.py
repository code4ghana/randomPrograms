'''
Created on Mar 30, 2010

@author: kwadwo
'''



from OutsideLibrary.table_parser import TableParser
from OutsideLibrary import ClientForm
from courseLib import *
import urllib2



def getStuff():
    mnemonic = raw_input("input course Mnemonic (ex:'math')")
    number = raw_input("input course number")
    response = urllib2.urlopen("http://rabi.phys.virginia.edu/mySIS/CS/CS_programs/Class_Search.php?Semester=1108")
    forms = ClientForm.ParseResponse (response, backwards_compat=False)
    response.close()
    form = forms[1]
    
    
    form["iCMnemonic"] = mnemonic
    
    form["iCNumber"] = number
    

    
    response1 = urllib2.urlopen(form.click()).read()
    
    p = TableParser()
    return [response1, p]
def parseDays(unparsedDays):
    dict={"MoWeFr":["Monday","Wednesday","Friday"],"Tu":["Tuesday"],"Th":["Thursday"]}
    if(unparsedDays in dict):
        return dict[unparsedDays]
    return []
    
    
def main():
    stuff = getStuff()
    p = stuff[1]
    p.feed(stuff[0])
    sections = []
    
    #populating sections list
    for i in p.doc[1][2:]:
        days,time = i[6].split(" ",1)
        days=parseDays(days.strip())
        sectDays=[]
        for j in days:
            sectDays.append(SectionDay(j,time.strip()))
        location = i[7].replace("\n", "").replace("\r", "")
        instructor = i[5].replace("\n", "").replace("\r", "")
        status = i[3]
        #checking whether this day is part of a previous section
        if i[0] == "":
            sections[-1].classDays.append(sectDays)
            continue;
        sections.append(Section(i[0], sectDays, instructor, location, status))
#    print p.doc[1][1][0]
    

    c=Course(p.doc[1][1][1], p.doc[1][1][0], sections)
    sched1=Schedule(1)
    #get a sample section and add it to the schedule
#    for i in c.sections[0].classDays:
#        sched1.putSchduledDay(i.name, c, c.sections[0].sectionNumber)
#    print secdays
#    sched1.putSchduledDay("Monday", c)
#    for i in sections:
#        print "Section #: ", i.sectionNumber
#        print "Days: ", i.classDays.name
#        print "instructor: ", i.instructor
#        print "status: ", i.status
#        print "location: ", i.location
#        print "\n"
        
if __name__ == '__main__':
    main()
