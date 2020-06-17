package com.star.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    private final static PropertyMgr instance = new PropertyMgr();

    private PropertyMgr(){

    }

    public static PropertyMgr getInstance(){
        return instance;
    }

    private Properties props = null;

    public Object get(String key){
        if(props==null){
            synchronized (this){
                if(props==null) {
                    props = new Properties();
                    try {
                        props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return props.get(key);
    }
    public int getInt(String key){
        Object o = get(key);
        return Integer.parseInt(o.toString());
    }
    public String getString(String key){
        Object o = get(key);
        return o.toString();
    }
}
