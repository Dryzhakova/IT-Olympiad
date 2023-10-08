import sys
import os

def antisymmetrics(data_input):
    # sprawdzamy, czy napis jest antysymetryczny
    for i in range(len(data_input)):
        if data_input[i] == data_input[-i-1]:
            return False
    return True

def amount_antisymmetrics_fragments(data_input, output):
    count = 0
    # przechodzimy przez wszystkie możliwe podnapisy
    for i in range(len(data_input)):
        for j in range(i+1, len(data_input)+1):
            # sprawdzamy, czy podnapis o indeksach (i, j) jest antysymetryczny
            #i, j - начальный индекс и индекс остановки соответственно
            if antisymmetrics(data_input[i:j]):
                output += data_input[i:j]
                output += " "
                count += 1
    return count


# clear file
dir = 'D:\универ\Politechnika\Języki skryptowe\Projekt\Moj projekt\input'
for f in os.listdir(dir):
    os.remove(os.path.join(dir, f))
	
# example
length = int(input("Enter the length of the number > "))
data_input = input("Enter your number > ")

while(len(data_input) != length):
	data_input = input("The string you entered is not the correct length. Please, try again > ")
	
os.chdir("input")

with open(sys.argv[1],"a+") as g:
    g.write(str(data_input))
	
# example = "11001011"
output = []

amount = amount_antisymmetrics_fragments(data_input, output)
print("Amount of antisymmetrics fragments > ",amount)
print("Antisymmetric fragments > ", *output)

os.chdir("..")
os.chdir("output")
with open(sys.argv[1],"a+") as g:
    g.write(str(amount))
	
