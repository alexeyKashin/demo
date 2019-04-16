package com.example.demo.controllers;

import com.example.demo.entity.Visit;
import com.example.demo.repository.VisitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private VisitsRepository visitsRepository;

    @GetMapping("/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Alexey");

        Visit visit = new Visit();
        visit.description = String.format("Visited at %s", LocalDateTime.now());
        visitsRepository.save(visit);

        return new ModelAndView("index", model);
    }
}
