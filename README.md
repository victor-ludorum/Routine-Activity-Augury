# Routine-Activity-Augury

## Android App Part 
In our country the crimes with women and children are increasing day by day.And the main reason behind this is guardians don't know whether their child 
is in danger or not. So, to solve this problem I have created an app which tracks user activity and predicts any abnormalities if present in the user routine.
In the very first the app will note down all the user details along with their guardian email id in the Sign up activity of app. Then, it will also note down the 
most frequent places he or she will visit through map and we will store all these data. After this the main tracking activity starts, here we will start collecting 
the users activity through the mobile sensors i.e. accelerometer,gyrometer,magnetometer etc.In android we call sensorService class which helps to collect all the 
data of all the sensors present in . In the app I have maintained one JobScheduler Service which automatically calls in the background after every 15 minutes and check
whether the location of user is changed upto threshold(this threshold distance we have made according to type of user as Child have less and adults have more). If it has
changed that much then first it will ask the user to give response, whether it normal, semi-normal or rare/abnormal situation for him. This response is useful because in the machine 
learning part we are actually doing supervised learning so that whenever any abnormalities occur then the app should predict it and it will inform the guardian So, we are collecting all the sensor data including the latitude and longitude of the present location so that we can track their location. In this way all the user data get collected all the way.We have also made one ToDo section like if anyone wants to go to movie on any day then he can feed that thing in the app. Then that will not be prompted for any response. These data are weekly send to the server.I have used PHPMyAdmin server for this where I am sending all data in the json format with the help of volley in android.

## Machine Learning Part
Now the data is collected for the user and these data are used for predicting any abnormal situation of the user. Here, I have used Recurrent neural network with long short term 
memory to predict the type of situation the user is presently. The reason for using recurrent neural network is as it takes two inputs the present and recent past. This neural network
back propagate through the hidden layers of the network to reduce the error present in the output. Here, we have taken recent past as input because as the user present routine depends  
upon the past routine which he had followed. Hence, whenever it's present have any change which may have occurred in it's past routine. Then we have Long short term memory used which 
consist of three gates input gate, output gate and forget gate. As, in the long run some of the user routine change which our network should forget so that it can work with present
input. Therefore, it stores the past and forget some of them as per the input is received because app is running continuously tracking the routine of user. Finally, whenever any 
abnormalities is predicted the guardian should be notified through the app.
