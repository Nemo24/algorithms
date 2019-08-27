arr = [10, 22, 9, 33, 21, 50, 41, 60, 80]

max_sum = 0
index = -1
i = 0
temp_sum = 0

while i < len(arr) -1:
    while arr[i] < arr[i+1] and i < len(arr) -1:
        i = i + 1
        temp_sum = temp_sum + 1
    i = i + 1
    
    if temp_sum > max_sum:
        max_sum = temp_sum
        index = i 
    temp_sum = 0
           
print ("max_sum" + str(max_sum))
print ("index" + str(index))