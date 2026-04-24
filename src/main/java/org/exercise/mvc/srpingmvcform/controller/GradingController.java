package org.exercise.mvc.srpingmvcform.controller;

import jakarta.validation.Valid;
import org.exercise.mvc.srpingmvcform.model.GradingResult;
import org.exercise.mvc.srpingmvcform.model.StudentForm;
import org.exercise.mvc.srpingmvcform.service.GradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GradingController {

    private final GradingService gradingService;

    @Autowired
    public GradingController(GradingService gradingService) {
        this.gradingService = gradingService;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("studentForm", new StudentForm());
        return "form";
    }

    @PostMapping("/grade")
    public String processGrade(
            @Valid @ModelAttribute("studentForm") StudentForm studentForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        GradingResult result = gradingService.calculateGrade(studentForm);
        model.addAttribute("result", result);
        return "result";
    }
}