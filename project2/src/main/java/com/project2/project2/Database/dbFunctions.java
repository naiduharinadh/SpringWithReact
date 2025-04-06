package com.project2.project2.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.String;
import java.util.List;

@Service
public class dbFunctions {

    @Autowired


    mongodbRepo mongodbRepo ;

    public usersDocModel addUser(usersDocModel user){
        mongodbRepo.save(user);
        return user;
    }
/*
    public usersDocModel findmyuser(String Id){
        return mongodbRepo.findById(Id).get();
    }
*/
    public usersDocModel findmyuser(String Id) {
    try {
        return mongodbRepo.findById(Id).orElse(null);
    } catch (Exception e) {
        System.out.println("Error finding user with ID: " + Id + " - " + e.getMessage());
        return null;
    } finally {
     System.out.println("finally block executed due to catch funciton handeld erro");
    }
}


    public List<usersDocModel> getallusers(){
        return mongodbRepo.findAll();
    }

   //default_function
   public String default_func(){
        return "default_func_return";
   }


}
