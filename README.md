# slueth-zipkin-demo

This project demos Spring Cloud Slouth and Zipkin

Start by viewing  SLEUTH + ZIPKIN.pdf

## SLUTH

Start slueth sub project & someapp sub project:


Call / and /getLocalTime in sluth app from browser and note that (view the logs):

* RestTemplate calls are instrumented to keep traceId.

* LogService and DateService create spans themselves
 
 Call /getRemoteTime and view the logs, note the traceId in someApp as well.
 
## Zipkin
 
Start zipkin-demo subproject.
Do like above and go to Zipkin url. Note the:
 
* Traces
 
* The custom event from DateService
 
* The dependency tab