# Distributed-tracing-in-Java

## Description
Basic movie app based on microservices architecture to show the logic of distributed tracing.

Created in spring boot using spring frameworks:
  * WEB
  * JPA
  * Zipkin
  * Sleuth
  * Eureka client
  * Eureka server
  * Lombok
  * H2 database
  * Gateway

![movie_app](https://user-images.githubusercontent.com/72033031/181573281-eccf623c-157e-43a7-8a3a-f29e0801a67a.png)

## How to run
### Locally
1. Install and run SigNoz. **You will find how to do it on their site [https://signoz.io/docs/]**. In my opinion the easiest way is to use docker.
2. Download and configure **OpenTelemetry java instrumentation library** for each service. Once again, great explained on SigNoz website [https://signoz.io/docs/instrumentation/java/].
  2.1. Put opentelemetry-javaagent.jar in main directory. 
  2.2. Open and change `run_locally.sh` file. You have to provide YOUR IP of SigNoz Backend in `-Dotel.exporter.otlp.endpoint` in each service part. Do not run the script now.
3. Download and run Zipkin through java -jar .... . Instruction: https://zipkin.io/pages/quickstart.
4. Run `run_locally.sh` script.

### Via docker
1. Install and run SigNoz. **You will find how to do it on their site [https://signoz.io/docs/]**.
2. Download and configure **OpenTelemetry java instrumentation library** for each service. Once again, great explained on SigNoz website [https://signoz.io/docs/instrumentation/java/].
  2.1. Put opentelemetry-javaagent.jar in build directory in each service. (Build dir should appear when you open the project in your IDE). 
3. Change Dockerfile in each service. You have to provide YOUR IP of SigNoz Backend in `-Dotel.exporter.otlp.endpoint`.
4. Run `run_services_docker.sh` script.

If something went wrong change urls in application-docker.yml in each service to IPs of your docker containers.
