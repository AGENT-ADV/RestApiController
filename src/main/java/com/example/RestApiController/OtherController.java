package com.example.RestApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherController
{
    @Autowired
    User obj2;

    @GetMapping("/other_controller")
    public void testBean()
    {
        System.out.println("the address of bean in other controller :-> " + obj2);
    }
}
