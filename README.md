# OpenWeatherAPI
Integrated openweather api with java spring boot

Created a spring boot project where weather data is fetched using the weather API.

Main Logic:-
For accessing the WeatherAPi first an API key was created.
The city for which the weather has to be checked is entered by the user.
This location is passed in the API url call.
The response data is recieved in a BufferedReader object.
This object is then converted into a JSON string using the google Gson dependency.
Then the JSON data is filtered and attributed like Temperature,Pressure,Humidity,etc are extracted from the JSON string
These attributes are then stored in an object and displayed to the user.


Running The Code:-
Currently only the WeatherApplication.java is executable so we can compile the java file to run the code.


Improvements possible:-
HTML and Angular files are currently in the OpenWeatherAPI/weather/src/main/resources/static/, 
but due to limited time was not able to make a connection between AngularJS and Controller file.
To increase the security while sending and receiving API data Base64 encoder and decoder can be used.
The code can be split into modules for better accessibility modification and understanding.
For Example:-
Controller ServiceImpl DAOImpl DTO files can be created seperately for modular code.
Data can be stored in a DB and it can be updated after a fixed duration using a CRON job.
More weather information can be displayed from the data recieved in API.
For unit testing the code junit can be used.
