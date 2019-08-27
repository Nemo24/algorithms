import sys
def printBin(arr,n):
    if n < 0:
        print (arr)
    else :
        arr[n] = 0
        printBin(arr,n-1 )
        arr[n] = 1
        printBin(arr,n-1 )
def printBinary(n):
    array = [None] * n
    printBin(array,n-1)


printBinary(int(sys.argv[1]))