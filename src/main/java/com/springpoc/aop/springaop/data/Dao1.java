package com.springpoc.aop.springaop.data;

import com.springpoc.aop.springaop.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

    @TrackTime
    public String retriveSomething() {
        return "Dao1";
    }
}
