package com.mp.springboot.demo.springDemoApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // set up rest controller
public class FunRestController {

    // expose "/" that return Hello World!

    @GetMapping("/") // handle HTTP Get request
    public String sayHello() {
        return "Hello World!";
    }

    // expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run hard 5k!";
    }

    // expose a new endpoint for fortune
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day.";
    }
}
