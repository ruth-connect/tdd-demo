package com.connect_group.tdd_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MochaChaiExampleController {

	@RequestMapping({"/mocha-chai-example.html"})
    public String test() {
        return "mocha-chai-example/test";
    }
}
