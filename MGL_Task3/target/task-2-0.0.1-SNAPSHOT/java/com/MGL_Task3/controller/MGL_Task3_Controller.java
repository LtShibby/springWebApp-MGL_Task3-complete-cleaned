package com.MGL_Task3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MGL_Task3_Controller {

    @RequestMapping(value = { MGL_Endpoint_Constants.BLANK_ENDPOINT,
	    MGL_Endpoint_Constants.HOME }, method = RequestMethod.GET)
    public String home() {
	return "home";
    }
}
