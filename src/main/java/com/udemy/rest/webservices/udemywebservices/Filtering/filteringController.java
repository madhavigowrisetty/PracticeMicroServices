package com.udemy.rest.webservices.udemywebservices.Filtering;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class filteringController {

    //we just need to show username only
    @GetMapping("/userdetails")
    public MappingJacksonValue userDetails()
    {
        UserCredentials usercred= new UserCredentials("purna","purna123","mother");
        MappingJacksonValue mapping = new MappingJacksonValue(usercred);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username");
        FilterProvider filters= new SimpleFilterProvider().addFilter("usernameFilter", filter);
        mapping.setFilters(filters);
        return mapping;
    }
    // we just need to show usernme and security word
    @GetMapping("/userdetails/alldetails")
    public MappingJacksonValue allDetails()
    {
        List<UserCredentials> list = Arrays.asList(new UserCredentials("Priyanka", "Priyanka123", "nihira"), new UserCredentials("rama devi", "ramadevi123", "daddy"));
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username", "password","securityWord");
        FilterProvider filters= new SimpleFilterProvider().addFilter("usernameFilter", filter);
        mapping.setFilters(filters);
        return mapping;
    }


}
