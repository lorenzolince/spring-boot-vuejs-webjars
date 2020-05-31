package com.llh.springboot.vuejs.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author lorenzo
 */
@Controller
public class BackendController {

    @GetMapping("/") // frontend1
    public String getFrontend1(Model model) {
        model.addAttribute("name", "frontend 1");
        return "index";
    }

    @GetMapping("/frontend2")
    public String getFrontend2(Model model) {
        model.addAttribute("name", "frontend 2");
        return "frontend2/index";
    }
}
