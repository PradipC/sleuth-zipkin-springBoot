- Zipkin-server 
  - Download the latest zipkin from below url : <br/>
    https://jar-download.com/artifacts/io.zipkin.java/zipkin-server/

  - start zipkin-server :  <br/>
  java -jar zipkin-server-2.12.9-exec.jar


- SpringBoot App Deployment 
  - Running the application locally : <br/>
  mvn spring-boot:run

- Test Service
  - 1. tracing success url: <br/>
  		http://localhost:9081/microservice1 
      <br/>
  - 2. tracing delay url: <br/>
        (Note: Used threads in trace-microservice3 & trace-microservice3 to get delay response )
  		http://localhost:9081/microservice1/delay
      
       <br/>
  - 3. calling Fallback url: <br/>
       (Note: To test this scenario stop the trace-microservice4 ,so fallback method execute and get the connection timeout message as response )<br/>
        http://localhost:9081/microservice1/circuit-breaker
      <br/>
  - 4. calling Retry url: <br/>
       (Note:To test this scenario stop the trace-microservice4 , Before executing fallback method , running microservice call multiple times to stopped service , to get correct response .In out test case trace-microservice3 try 5 max attempts for 4seconds gap ) <br/>
  		http://localhost:9081/microservice1/circuit-breaker/retry
      <br/>
  - zipkin server UI url : <br/>
  http://localhost:9411/zipkin/
