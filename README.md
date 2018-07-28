# Routine-Activity-Augury

In our country the crimes with women and children are increasing day by day.And the main reason behind this is guardians don't know whether their child 
is in danger or not. So, to solve this problem I have created an app which tracks user activity and predicts any abnormalities if present in the user routine.
In the very first I will first note down all the user details along with their guardian email id in the Sign up activity of app. Then, I will also note down the 
most frequent places he or she will visit through map and we will store all these data. After this the main tracking activity starts, here we will start collecting 
the users activity through the mobile sensors i.e. accelerometer,gyrometer,magnetometer etc.In android we call sensorService class which helps to collect all the 
data of all the sensors present in . In the app I have maintained one JobScheduler Service which automatically calls in the background after every 15 minutes and check
whether the location of user is changed upto threshold(this threshold distance we have made according to type of user as Child have less and adults have more). If it has
changed that much then first it will ask the user to give whether it normal, semi-normal or rare/abnormal situation for him. This response is useful because in the machine 
learning part we are actually doing supervised learning so that whenever any abnormalities occur then the app should predict it and it will inform the guardian So, we are collecting all the sensor data including the latitude and longitude of the present location so that we can track their location. In this way all the user data get collected all the way.These data are weekly send to the server . I have used PHPMyAdmin server for this where I am sending all data in the json format with the help of volley in android.

Now the data is collected for the user and these data are used for predicting any abnormal situation of the user. Here, I have used RNN with LSTM to each of the normal and semi-normal
situations of the user and whenever any location with new values are received then that will calculate how much close it is with the normal , semi normal or any rare/abnormal situation.
And if the prediction is an abnormal situation then the guardian will be notified so that he may take proper action regarding it.
