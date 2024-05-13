function fn() {
  // See https://github.com/intuit/karate#karate-configjs for information on
  // this file.

  karate.configure("connectTimeout", 5000);
  karate.configure("readTimeout", 5000);

  let protocol = "http";
  let host = "localhost";

  let microservicePort = karate.properties["microservice.port"];
  if (!microservicePort) {
    microservicePort = "8080";
  }

  let config = {};
  config.microserviceUrl = protocol + "://" + host + ":" + microservicePort;
  config.cat_endpoint = '/catFacts'
  config.hello_endpoint = '/hello'
  config.health_endpoint = '/actuator/health'
  config.info_endpoint = '/actuator/info'
  config.repo_endpoint = '/starredRepo'
  config.credential = {username:"user",password:"password"}
  return config;
}
