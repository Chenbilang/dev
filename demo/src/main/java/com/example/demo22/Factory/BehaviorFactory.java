package com.example.demo22.Factory;

import com.example.demo22.pojo.Behavior;
import com.example.demo22.pojo.Fly;
import com.example.demo22.pojo.Walk;

public class BehaviorFactory {

    public static Behavior getBehavior(String behavior) {
        if (behavior == "fly") {
            return new Fly();
        }
        if (behavior == "walk") {
            return new Walk();
        }else{
            return null;
        }

    }
}

