package com.udemy.rest.webservices.udemywebservices.User;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static ArrayList<User> userarray = new ArrayList<User>();

    static {
        userarray.add(new User(1, "Madhavi", new Date()));
        userarray.add(new User(2, "Shrikanth", new Date()));
    }
    int idcount=2;

    //to return the list of user from db
    public ArrayList<User> allusers()
    {
        return userarray;
    }

    //to add a new user to db
    public User addUser(User userobj)
    {
        if(userobj.getId() == null)
        {
            userobj.setId(++idcount);
        }
        userarray.add(userobj);
        return userobj;
    }
    // to find a specific user from DB
    public User findUser(Integer id)
    {
        for (User i: userarray  )
        {
            if (i.getId()== id)
                return i;
        }
        return null;
    }

}
