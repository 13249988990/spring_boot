package com.wick.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wick.bean.Test;


@RestController
public class TestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/test")
    public Test dealTest(@RequestParam(value="name", defaultValue="World") String name) {
        return new Test(counter.incrementAndGet(),
                            String.format(template, name));
    }@RequestMapping("/test1")
    public Test dealTest1(@RequestParam(value="name", defaultValue="World") String username) {
        return new Test(counter.incrementAndGet(),
                            String.format(template, username));
    }
    @RequestMapping("/welcome")
    public ModelAndView welcome() {
    	ModelAndView mv= new ModelAndView("/index");
    	mv.addObject("name", "lqx");
    	return mv;
    }
}