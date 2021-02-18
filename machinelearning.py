%matplotlib inline
import numpy as np
import pandas 
from sklearn import utils 
import matplotlib
from sklearn import svm

from sklearn.svm import SVC
from sklearn.metrics import accuracy_score

names = ['d1', 'd2', 'd3', 'd4', 'd5', 'd6', 'd7', 'd8', 'd9', 'd10',
         'd11', 'd12', 'd13', 'd14', 'd15', 'd16', 'd17', 'd18', 'd19', 'd20',
        'd21', 'd22', 'd23', 'd24','checking']
data = pandas.read_csv("./values.csv", sep=" ", names=names)
print("CSV Values are ", data)
y = data.pop('checking').values

data.shape
print(data[0:5])

data.plot(kind='line', title='Honest Data Values Plotted')


from sklearn import svm
clf = svm.SVC(kernel='linear')

clf.fit(data, y)
p = clf.predict([[1,2 ,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0]])

if p == 0:
  output = 'ACCURATE'
else:
  output = 'MISINFORMATION'
print("Your statement is ", p, output)

from sklearn import metrics
print("Accuracy:", metrics.accuracy_score(y_test, y_pred))
