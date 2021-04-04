## About Words
This project a take-home challenge provided to improve the search and observation power of Labforward's note solution.

### Assignment Details
- Start Time: Around 5:20am, April 4th, 2021
- First Draft End time: 9:20am, April 4th, 2021
- Total Time Spent: 5+ hrs

## What's new
1. Added provided functionality
2. included unit tests for services involved
3. Added Integration Tests to on the Similarity and Frequency Controllers

### Note Worthy
1. payload was passed using the POST method based on the assumption that the text (haystack) could be really large and possibly exceed the allowance for a typical GET method.
2. the splitting of the text into words for work only uses non-word characters so words like '-' will fail at the moment

### How to run the Application
At the moment, you can do this by 

1. Using the gradle command -

```./gradlew bootRun```

2. Using docker-compose command:

```docker-compose up -d```

The application runs on port 8081 and this can be changed from the -
- application.yml file or passed in while starting the application
- docker-compose.yml file while using the docker-compose command

### How to Access the APIs
To use the APIs, please use this link -

```localhost:8081/swagger-ui.html#/```


## Further Improvements
1. A more improved method of splitting the word will be implemented
2. Provide the opportunity to provide a file as the "text" property will improve the UX
3. Provision of a CI/CD pipe to ensure tests pass on being merged to the master (or ideally release/staging | release/product) branch
4. Caching of results given inputs to improve on speed for processing
5. Converting this application to a microservice
