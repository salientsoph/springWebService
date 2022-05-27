package com.jojoldu.book.springboot.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //controller 를 JSON을 반환하는 controller로 만들어줌
public class HelloController {

    @GetMapping("/hello")  //Get의 요청을 받을 수 있는 API를 만들어줌
    public String hello(){
        return "hello";
    }



}
