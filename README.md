# slueth-zipkin-demo

This project demos Spring Cloud Slouth and Zipkin

Start by viewing [SLEUTH + ZIPKIN.pdf](https://github.com/kimsaabyepedersen/slueth-zipkin-demo/blob/master/SLEUTH%20%2B%20ZIPKIN.pdf)

## SLUTH

Start slueth sub project & someapp sub project via their respective main methods:


Call / and /getLocalTime in sluth app from browser and note that (view the logs):

* RestTemplate calls are instrumented to keep traceId.

* LogService and DateService create spans themselves

Call /getRemoteTime (will make a call from sleuth app to someapp app) and view the logs, note the traceId in someApp as well.
 
## Zipkin
 
Start zipkin-demo subproject.
Do like above and go to Zipkin url. Note the:
 
* Traces
 
* The custom event from DateService
 
* The dependency tab


# Side  note: Image credits

Images in the presentation are from:

* [The Sleuth - http://www.thegoldqueen.com](http://www.thegoldqueen.com/wp-content/uploads/2011/03/15-sleuth-large.jpg)

* [The Span/Trace visualization - http://cloud.spring.io/spring-cloud-sleuth/spring-cloud-sleuth.html](https://raw.githubusercontent.com/spring-cloud/spring-cloud-sleuth/master/docs/src/main/asciidoc/images/trace-id.png)
