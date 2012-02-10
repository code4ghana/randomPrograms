'''
Created on Mar 30, 2010

@author: kwadwo
'''

class Section:
        
    def __init__(self, secNum, days="null", instr="null", room="null", curStatus="null"):
        self.sectionNumber = secNum
        self.classDays=days
        self.instructor = instr
        self.location = room
        self.status = curStatus
    def getTimeByDay(self,nameOfDay):
        print self.classDays
        for i in self.classDays:
            print i
            if i.name == nameOfDay:
                return i.start
            
    def __eq__(self,aSection):
        return self.sectionNumber==aSection.sectionNumber
        
    
class SectionDay:
    def __init__(self, day,time):
        self.name = day
        self.start, self.end = time.split("-")
        self.start.strip()
        self.end.strip()
    def __eq__(self,aScheduleDay):
        same=self.name==aScheduleDay
        same= same and self.start==aScheduleDay.start
        same= same and self.end==aScheduleDay.end
        return same

class Course:
    def __init__(self, n, Id, sects):
        self.name = n
        self.courseID = Id
        self.sections = sects
        
    def __eq__(self,aCourse):
        same=self.courseID==aCourse.courseID
        same= same and self.name==aCourse.name
        return same
    
    def getSectionByID(self,ID):
        if Section(ID) in self.sections:
            ind=self.sections.index(Section(ID))
            return self.sections[ind]
        
        
    
class Schedule:
    def __init__(self,num):
        self.number=num
        self.days={"Monday":ClassDay("Monday"),"Tuesday":ClassDay("Tuesday"),
                   "Wednesday":ClassDay("Wednesday"),"Thursday":ClassDay("Thursday"),"Friday":ClassDay("Friday")}
        
    def setNum(self,num):
        self.number=num
     
    def putSchduledDay(self,dayName,course,sectionID):
        print dayName
        if dayName in self.days:
            self.days[dayName].insertCourse(course,sectionID)

class ClassDay:
    def __init__(self,name):
        self.nameOfDay=name
        self.timeMap=dict()
        #atempt to put the course for this day
    def insertCourse(self,aCourse,SectionID):
        time=aCourse.getSectionByID(SectionID).getTimeByDay(self.nameOfDay)
        if(time in self.timeMap):
            return False;
        self.timeMap[time]=aCourse
        return True
        
    
        