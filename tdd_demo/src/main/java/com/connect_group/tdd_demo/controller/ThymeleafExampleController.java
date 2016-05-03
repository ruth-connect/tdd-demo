package com.connect_group.tdd_demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafExampleController {

	@RequestMapping("/thymeleaf-example.html")
	public ModelAndView starWars() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("image", "/images/yoda.jpg");
		model.put("quote", "Do, or do not. There is no try.");
		
        return new ModelAndView("thymeleaf-example/star-wars", model);
	}
}
