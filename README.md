## Java Coding Challenge

#### Objectvie
Your objective is to build an incredible experience for a simple rest service to retrieve user's information, while at the same time impressing us with how simple and clean your code is.

Please utilize this clean sprint boot project. Run it by typing `./mvnw` in command line.

We receive many submissions daily, yours needs to stand out. We'd love to be impressed by the coding style, by the unit test, and by the little touches that make it slick.



#### Requirments
1. Endpoint A: by typing url _http://localhost:8080/users_ in a browser, we expect a list of users returning in JSON format.
E.g.,
 [
    { "id": 1, "name":"John", "age":31, "city":"New York" },
    { "id": 2, "name":"Doe", "age":22, "city":"Vancouver" }
 ]
 
2. Endpoint B: by typing url _http://localhost:8080/user/2_ in a browser, we expect a user with id=2 returning in JSON format.
    E.g., { "id": 2, "name":"Doe", "age":22, "city":"Vancouver" }
    
3. Unit Test: we expect to see unit tests for above two endpoints.

4. Optional: Uniform error handling, your code should also handle potential errors.

5. Optional: Security, in most cases, a token is required to authorize the access of an endpoint. To make it happen, we expect to see a simple and general security control.

#### Evaluation your solution

1. We were able to run your code using `./mvnw`

2. Tasks completed - are the tasks well completed

3. Code quality - is your code clean, simple, readable, well designed

4. Unit test - the endpoint and service are well tested

5. Errors - handle errors gracefully

#### Submission

* Do not place your code on GitHub or any other source version control platform.

* Please email us a zip file, that we can unzip

* Send your submission to `zheng@omegasys.eu`, with subject `java-coding-challenge`.