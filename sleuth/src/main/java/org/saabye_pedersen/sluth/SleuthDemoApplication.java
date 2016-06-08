package org.saabye_pedersen.sluth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Callable;


@RestController
public class SleuthDemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SleuthDemoApplication.class);

    @Autowired
    private Tracer tracer;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DateService dateService;

    @Autowired
    private LogService logService;

    @Value("${server.port}")
    private int appPort;

    @Value("${otherapp.port}")
    private int otherappPort;



    @RequestMapping("/")
    public String home() {
        LOGGER.info("Request to / endpoint");
        return "Hello World";
    }

    @RequestMapping("/getRemoteTime")
    public String getRemoteTime() throws URISyntaxException {
        LOGGER.info("Request to /getRemoteTime endpoint");

        logService.log("Will call remote service");

        ResponseEntity<String> forEntity = restTemplate.getForEntity(new URI("http://localhost:"+otherappPort+"/getTime"), String.class);
        LOGGER.info("Got response code: {}", forEntity.getStatusCode().toString());
        return "The remote time is: " + forEntity.getBody();
    }

    @RequestMapping("/getLocalTime")
    public String getLocalTime() throws URISyntaxException {
        LOGGER.info("Request to /getLocalTime endpoint");

        logService.log("Will call local service");

        ResponseEntity<String> forEntity = restTemplate.getForEntity(new URI("http://localhost:"+appPort+"/getTime"), String.class);
        LOGGER.info("Got response code: {}", forEntity.getStatusCode().toString());
        return "The localtime is: " + forEntity.getBody();
    }

    @RequestMapping("/getTime")
    public String getTime() {
        LOGGER.info("Request to /getTime endpoint");
        return dateService.getTimeAsString();
    }


}
