import os, Tkinter, tkFileDialog,re
##goes through every file and changes replaces strings
def recur_change(path, string_replace, string_with):
    regex=re.compile(string_replace)
    
    for file in os.listdir(path):
        dirfile = os.path.join(path, file)
        if os.path.isdir(dirfile):
            recur_change(dirfile, string_replace, string_with)
            continue;
        if dirfile.endswith(".txt") or dirfile.endswith(".html"):
            
            # read file content
            fhandle = open(dirfile, 'r')
            text = fhandle.read()
            fhandle.close()
            substitutions = 0
            # unpack the subn() function and the replace string
            cffl=[]
            cffl.append((regex.subn,string_with))
            for subnfunc, replaces in cffl:
                text, numOfChanges = subnfunc(replaces, text)
                substitutions += numOfChanges
            if substitutions:
                # first move away the original file
                bakFileName = '%s%s' % (dirfile, '_bak'+dirfile[dirfile.rfind("."):])
                if os.path.exists(bakFileName): os.unlink(bakFileName)
                os.remove(dirfile)
                # now write the new file content
                fhandle = open(dirfile, 'w')
                fhandle.write(text)
                fhandle.close()
                

      

def main():
  
    root = Tkinter.Tk()
    root.withdraw()
    dirname = tkFileDialog.askdirectory(parent=root, initialdir="/home/kwadwo/Documents/trial", title='pick a directory')
    replacethis = raw_input("what to look for? ")
    replacewith = raw_input("what to replace with")
    
    print "in the folder ", dirname, " replace ", replacethis, " with ", replacewith
    recur_change(dirname, replacethis, replacewith)

if __name__ == '__main__':
    main()         
