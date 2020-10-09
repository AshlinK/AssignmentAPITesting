# ApiTestAssignmentSolution

This API test automation framework is created with the help of Retrofit(Rest Client) in Java using Maven and TestNg.
Download or clone the project and open it in any IDE(IntelliJ,Eclipse,etc). 


You will need an API key which you can generated at the below link by signing up.

https://home.openweathermap.org/users/sign_up

Once you have signed up, the API Key will be sent to your mail. Save it.

Once the project has been downloaded open the env.properties file and paste the API key that was created for you.

Download all the maven dependencies and run the tests using below command,

mvn test exec:java -Dexec.mainClass='src.test.api.WeatherTest'

Alternatively, you can also run the tests manually by clicking on 'Run test' button in the IDE as most of the IDE's have support for TestNG.
