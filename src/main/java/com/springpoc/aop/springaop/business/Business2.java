package com.springpoc.aop.springaop.business;

import com.springpoc.aop.springaop.data.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Business2 {

    @Autowired
    private Dao2 dao2;
    public String calculateSomething(){
        return dao2.retriveSomething();
    }
}
