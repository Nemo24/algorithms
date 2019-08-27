import sys
def perm(txt,accum=""):
    if len(txt) == 0:
        print (accum)
    else:
        for i in range(len(txt)):
            perm(txt[:i] + txt[i+1:],txt[i]+accum)

perm(sys.argv[1])