import sys
def printDecimal(n,soFar=""):
    if n == 0:
        print (soFar)
    else:
        for i in range(10):
            printDecimal(n-1,soFar + str(i))


printDecimal(int(sys.argv[1]))

