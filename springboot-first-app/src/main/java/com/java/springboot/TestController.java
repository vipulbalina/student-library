package com.java.springboot;

import org.apache.tomcat.jni.Time;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
public class TestController {


    @GetMapping("/test")
    public String testController(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return "The Time and Date right now is "+now;
    }

    @PostMapping("/test")
    public String timeController(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return "The Time and Date right now is "+now;
    }
    @PostMapping("/name")
    public String name(@RequestBody String name){
        if(name.length()<3){
            return "Invalid Name. It should be more than 3 letters";
        }
        else{
            return "Welcome: "+name;
        }

    }

    @PutMapping("/square")
    public String squreNumber(@RequestBody String a){
        int NumberA = Integer.parseInt(a);
        int square = NumberA*NumberA;
        return "The square of the number is : "+square;
    }

    @GetMapping("/Addition/{num1}/{num2}")
    public int addition(@PathVariable int num1,@PathVariable int num2){
        int add = num1+num2;
        return add;
    }

    @GetMapping("/division/{num1}/{num2}")
    public String division(@PathVariable double num1, @PathVariable double num2){
        if(num2==0){
            return "The number2 cannot be 0";
        }
        double division = num1/num2;

        return "The divison of two numbers value is : "+division;
    }




}
