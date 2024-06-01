package com.mp.springboot.thymeleafdemo.controller;

import com.mp.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${langugages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        // create a student object
        Student student = new Student();

        // add student object as a model attribute
        model.addAttribute("student", student);

        // add the list of countries to the model
        model.addAttribute("countries", this.countries);

        // add the list of languages to the model
        model.addAttribute("languages", this.languages);

        // add the list of systems to the model
        model.addAttribute("systems", this.systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student) {

        // log input data
        System.out.println("student=" + student.getFirstName() + " " + student.getLastName());

        return "student-confirmation";
    }

}
