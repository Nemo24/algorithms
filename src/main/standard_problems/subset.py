import sys
def sub(s,chosen):
    if len(s) ==0:
        print (str(chosen))
        return
    sub(s[1:],chosen+s[0])
    sub(s[1:],chosen)
    

def subset(s):
    sub(s,"")


subset(sys.argv[1])