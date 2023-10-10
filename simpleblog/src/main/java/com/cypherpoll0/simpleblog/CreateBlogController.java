package com.cypherpoll0.simpleblog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController 
public class CreateBlogController {
    
    @RequestMapping("/")
    public String hello() {
        return "Hello";
    }
}
