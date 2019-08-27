import sys
def dodiceRoll(n,soFar=[]):

    if n == 0:
        print (str(soFar))

    else:
        for i in range(1,7):
            soFar.append(i) # your choice step
            dodiceRoll(n-1,soFar) #recursion step
            soFar.remove(i)# undo step ( remove last element that was added in line 8)


dodiceRoll(int(sys.argv[1]))

