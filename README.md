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
