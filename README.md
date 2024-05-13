# Spring Boot Coding Exercise

This is a simple coding exercise that will allow you to demonstrate your knowledge
of spring boot by using a microservice to call a downstream service and return
some results.

## Project Structure

This is a multi-module maven project with two modules:

- The `micoservice` module produces a spring boot application.
- The `functional-tests` is used to run functional tests using the [karate](https://github.com/intuit/karate) library.

## How to run application

First of all, start the application in your IDE or use the command line:

```shell
mvn spring-boot:run -pl microservice
```

Once the application is running, visit the client application in the browser at `localhost:8080/<endpoint>`.

The available endpoints are:

- `hello`: Displays a simple greeting message.
- `catFacts`: Retrieves interesting facts about cats.
- `starredRepo`: Retrieves top n repos from GitHub API with the highest stars created from the last 7 days.

Once you access the URL, you will be redirected to the login page. Enter the following credentials:
- `Username`: user
- `Password`: password
## How to run functional test cases

```shell
mvn clean verify
```

## Instructions

Select one of the two exercises below and add the required behaviour to the spring boot application in the microservice
module. You can:

- Add libraries you need.
- Refactor any of the existing code.

You will see that there are already a couple of endpoints in the `microservice` they are fundamentally there to
demonstrate the use of the [karate](https://github.com/intuit/karate) library and should not be taken as complete
examples.

### Assessment

Please assume this piece of code would be deployed to a production environment and managed by software developers into
the future.

Your submission will be judged on the following criteria:

- The solution works and compiles.
- The solution appropriately solves the problem.
- The solution has been tested and has appropriate tests.
- The solution has considered future maintainability, extensibility, and traceability.
- The solution has considered application security.

## The Exercises

Example curl api calls for these exercises are listed in the following
gist https://gist.github.com/bartonhammond/0a19da4c24c0f644ae38

**1. Find the hottest repositories created in the last week**

Use the [GitHub API][1] to expose an endpoint in this microservice that will get a list of the
highest starred repositories in the last week.

The endpoint should accept a parameter that sets the number of repositories to return.

The following fields should be returned:

      html_url
      watchers_count
      language
      description
      name

**2. Find the oldest user accounts with zero followers**

Use the [GitHub API][1] to expose an endpoint in this microservice that will find the oldest
accounts with zero followers.

The endpoint should accept a parameter that sets the number of accounts to return.

The following fields should be returned:

      id
      login
      html_url

[1]: http://developer.github.com/v3/search/#search-repositories
