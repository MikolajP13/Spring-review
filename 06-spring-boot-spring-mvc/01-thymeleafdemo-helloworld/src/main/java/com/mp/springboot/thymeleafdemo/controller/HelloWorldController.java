package com.mp.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // method to process the form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // method to read form data and add it to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShout(HttpServletRequest request, Model model) {
        // read the request parameter from the HTML form
        String name = request.getParameter("studentName");

        // convert data
        name = name.toUpperCase();

        // create message and add it to the model
        String message = "Yo! " + name;
        model.addAttribute("message", message);

        return "helloworld";
    }

    // method to read form data and add it to the model with @RequestParam
    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String studentName, Model model) {

        // create message and add it to the model
        String message = "Hey " + studentName;
        model.addAttribute("message", message);

        return "helloworld";
    }

}
