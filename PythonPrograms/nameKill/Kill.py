#Author : Jeff Appiah Kusi 
#email :: jeffkusi@gmail.com

import commands,re,sys

def kill(process):
    cmd='ps -A'
    (status,output)=commands.getstatusoutput(cmd)
    if(status==False):

        processes=re.findall(r'(\d+).+\d\d:.+('+process+'.*)',output)
#        processes=re.findall(r'(\d.+('+process+')',output)
        if(processes):
            if(len(processes)>1):
                print "multiple processes by that name"
            index=0
            for i in processes:
                print '[',index,']',i[0], " ", i[1]
                index+=1
            index=0
            if(len(processes)>1):
                killspot="a"
                while(killspot.isdigit()==False):
                    killspot=raw_input("please type the number of the process to be killed")
                index=int(killspot)-1
            print "Killing process",processes[index][0]
            cmd='kill '+processes[index][0]
            (status,output)=commands.getstatusoutput(cmd)
        print "couldn't find any process by such name"
        return
    print "got an error"
    
def main():

    if(len(sys.argv)<2):
        print "need name of the process"
        return

    kill(sys.argv[1])
if __name__=='__main__':
    main()
