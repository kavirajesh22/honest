from flask import Flask
from flask import render_template
from flask import request
import numpy as np
import pandas 
from sklearn import utils 
import matplotlib
from sklearn import svm
from sklearn.svm import SVC
from sklearn.metrics import accuracy_score

# creates a Flask application, named app
app = Flask(__name__)
clf = None
wordtable = {}

# a route where we will display a welcome message via an HTML template
@app.route("/")
def hello():
    message = "Hello, World"
    return render_template('index.html', message=message)


@app.route("/CheckFact")
def CheckFact():
    veriftext = request.args.get('fact')
    print("Verifying Information Accuracy for ", veriftext)
    p = encodeVerifyText(veriftext)
    print("PRedicting for ", p)
    result = clf.predict([p])
    if result == 0:
      output = 'ACCURATE'
    else:
      output = 'MISINFORMATION'
    return output

def encodeVerifyText(veriftext):
	global wordtable
	encoded = []
	words = veriftext.split()
	for w in words:
		if w in wordtable:
			encoded.append(wordtable[w])
		else:
			print("Not in wordtable")
			encoded.append(0)
	count = 26 - len(words)
	while count > 0:
		encoded.append(0)	
		count = count - 1	
	return encoded

def rebuildDictionary(): 
	global wordtable
	dictfile = open('../../data/dictionary.txt', 'r')
	Lines = dictfile.readlines()
	count = 1
	for line in Lines:
		print("word is ", line)
		s = line.strip(' \t\n\r')
		wordtable[s] = count
		count = count + 1
	dictfile.close()

def FitModel():
    rebuildDictionary()
    global clf
    print("Learning and Fitting the Model")
    names = ['d1', 'd2', 'd3', 'd4', 'd5', 'd6', 'd7', 'd8', 'd9', 'd10',
         'd11', 'd12', 'd13', 'd14', 'd15', 'd16', 'd17', 'd18', 'd19', 'd20',
        'd21', 'd22', 'd23', 'd24','d25', 'd26', 'checking']
    data = pandas.read_csv("../../data/officialvalues.csv", sep=" ", names=names)
    clf = svm.SVC(kernel='linear')
    y = data.pop('checking').values
    clf.fit(data, y)


# run the application
if __name__ == "__main__":
    FitModel()
    app.run(debug=True)