import json

#reading file
with open('./currency.json', 'r') as myfile:
    data = myfile.read()
#parsing file
obj = json.loads(data)
#showing values
print("usd: " + str(obj['usd']))
print("eur: " + str(obj['eur']))
print("gbp: " + str(obj['gbp']))