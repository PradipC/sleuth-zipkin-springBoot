- Zipkin-server 
  - Download the latest zipkin from below url : <br/>
    https://jar-download.com/artifacts/io.zipkin.java/zipkin-server/

  - start zipkin-server :  <br/>
  java -jar zipkin-server-2.12.9-exec.jar


- SpringBoot App Deployment 
  - Running the application locally : <br/>
  mvn spring-boot:run

- Test Service
  - To call get rest url : <br/>
  http://localhost:9081/microservice1

  - zipkin server UI url : <br/>
  http://localhost:9411/zipkin/
