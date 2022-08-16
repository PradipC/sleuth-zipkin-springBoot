Zipkin-server : 
Download the latest zipkin from below url :
https://jar-download.com/artifacts/io.zipkin.java/zipkin-server/

start zipkin-server : 
java -jar zipkin-server-2.12.9-exec.jar


#Running the application locally : 
mvn spring-boot:run

#To call get rest url : 
http://localhost:9081/microservice1

#zipkin server UI url : 
http://localhost:9411/zipkin/