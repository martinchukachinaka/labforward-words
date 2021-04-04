## About Words
This project a take-home challenge provided to improve the search and observation power of Labforward's note solution.

### Assignment Details
- Start Time: Around 5:20am, April 4th, 2021
- First Draft End time: 9:20am, April 4th, 2021

## What's new
1. Added provided functionality
2. included unit tests for services involved
3. Added Integration Tests to on the Similarity and Frequency Controllers

### Note Worthy
1. payload was passed using the POST method based on the assumption that the text (haystack) could be really large and possibly exceed the allowance for a typical GET method.
2. the splitting of the text into words for work only uses non-word characters so words like '-' will fail at the moment

### How to Application
At the moment, you can do this by using this command -

```./gradlew bootRun```

The application runs on port 8081 and this can be changed from the application.yml file or passed in while starting the application

