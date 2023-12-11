package com.grocerystore.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpErrorController {

	@RequestMapping(value="/error/403")
	public String handle403() {
		return ".unauthorozed";
	}
	@RequestMapping(value="/error/404")
	public String handle404() {
		return ".notfound";
	}
}
