package com.udemy.rest.webservices.udemywebservices.HelloWorld;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//Controller
@RestController
public class HelloWorld {
    @Autowired
    private MessageSource messageSource;

    //this is a get service
    //path: URI: /hello-world
    //when this service is hit (http://localhost:8080/hello-world), we should call a method which return some string
// @RequestMapping(method = RequestMethod.GET, path = "/hello-world") or @GetMapping(path = "/hello-world") can be added to make this method a get request with path
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello Madhavi!!";
    }

    @GetMapping(path = "/hello-world/internationalization")
    public String helloWorldInternationalization(@RequestHeader(name = "Accept-Language") Locale locale){
        return messageSource.getMessage("good.morning.message",null,locale);
    }

    @GetMapping(path = "/hello-world-obj")
    public HelloWorldObj helloWorldObj(){
        return new HelloWorldObj("Hello Madhavi Shrikanth Bean");
    }
//how to implement path variable : getting specific user details /hello-world-obj/path-variable/Madhavi
    @GetMapping(path = "/hello-world-obj/path-variable/{name}")
    public HelloWorldObj helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldObj(String.format("Hello, %s", name));
    }

}
