package com.example.RestApiController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController
{
    @Autowired
    User obj1;

    @GetMapping("/my_controller")
    public void testBean()
    {
        System.out.println("the address of bean in my controller :-> " + obj1);
    }

    Map<Integer, User> hm = new HashMap<>();

    @GetMapping("/get_users")
    public List<User> getUsers()
    {
        List<User> listOfUsers = new ArrayList<>();

        for(User u : hm.values()) listOfUsers.add(u);

        return listOfUsers;
    }

    @GetMapping("/get_user/{id}")
    public User getUser(@PathVariable("id") int id)
    {
        return hm.get(id);
    }

    @PostMapping("/add_user")
    public void addUser(@RequestParam("id") int id, @RequestParam("name") String name,
                        @RequestParam("age") int age, @RequestParam("country") String country){

        User new_user = new User(id,name, age, country);
        hm.put(id, new_user);
    }

    @PostMapping("/add_user_body")
    public void addUserBody(@RequestBody(/*required == true by default*/) User u)
    {
        hm.put(u.getId(), u);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id)
    {
        hm.remove(id);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody() User u)
    {
        hm.put(id, u);
    }
}
