package com.example.firstspringproject;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class Controller {

    @RequestMapping("req") //http://localhost:8080/req
    public String requestName() {
        return "My Name is <h3>Himanshu Gupta</h3>";
    }
    
    //read data
    @GetMapping("/get")  //http://localhost:8080/get
    public String doGet() {
        return "😀Hello, you are in get method";
    }

    //create data
    @PostMapping("/post")
    public String doPost() {
        return "🚀Hello, Welcome to Post method";
    }
    
    //update data
    @PutMapping("/put")
    public String doPut() {
        return "🔥Hello, you are in put method.";
    }

    //delete data
    @DeleteMapping("/delete")
    public String doDelete() {
        return "🎉Hello, you are in delete method.";
    }
}
