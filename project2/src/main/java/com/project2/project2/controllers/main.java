package com.project2.project2.controllers;

import com.project2.project2.Database.dbFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project2.project2.Database.usersDocModel;
import java.util.*;
import java.lang.String;
import java.util.List;

@RestController
public class main {

    @GetMapping("/hello")
    public String helloworld(){
        return "hello world ";
    }

/*
    @Autowired
    public dbFunctions dbFunctions;
    @GetMapping ("/saveuser/{userId}/{Contact}/{email}/{ReEnterPassword}")
    public usersDocModel saveuser(@PathVariable String userId,
                                  @PathVariable String Contact,
                                  @PathVariable String email,
                                  @PathVariable String ReEnterPassword){
        usersDocModel obj = new usersDocModel();
        obj.setUserid(userId);
        obj.setPhone(Contact);
        obj.setEmail(email);
        obj.setPassword(ReEnterPassword);
        dbFunctions.addUser(obj);
        return obj;
    }
*/
@Autowired
public dbFunctions dbFunctions;
public usersDocModel userobj;
    @PostMapping ("/saveuser")
    public usersDocModel saveuser(@RequestBody usersDocModel userobj){

        /*usersDocModel obj = new usersDocModel();
        obj.setUserid(userobj.getUserid());
        obj.setPhone(userobj.getPhone());
        obj.setEmail(userobj.getEmail());
        obj.setPassword(userobj.getPassword()); */

        dbFunctions.addUser(userobj);
        return userobj;
    }

    @GetMapping("/{userId}")
    public usersDocModel getUser(@PathVariable String userId) {
        return dbFunctions.findmyuser(userId);
    }

    @GetMapping("/allusers")
    public List<usersDocModel> gettotalusers(){
        return dbFunctions.getallusers();
    }
    
    @GetMapping("/")
    public String default_func(){
	    return "Welcome to Tomcat Application.........!! java version 17, Maven and spring boot based application";
     }
}
