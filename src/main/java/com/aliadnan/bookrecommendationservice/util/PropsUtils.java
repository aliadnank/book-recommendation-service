package com.aliadnan.bookrecommendationservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Ali
 * @createdOn 2018/11/3
 */
@Component
public class PropsUtils {

    @Autowired
    Environment environment;

    public String getValue(String key){
        return environment.getProperty(key);
    }
}
