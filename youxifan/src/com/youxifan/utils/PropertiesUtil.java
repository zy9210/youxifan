package com.youxifan.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertiesUtil extends PropertyPlaceholderConfigurer {
    
	private static Properties p ;
 
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory,
              Properties props) throws BeansException {
         super .processProperties(beanFactory, props);
         p = props;
     }
 
     public static String getProperty(String key) {
         return p.getProperty(key);
     } 
     
}