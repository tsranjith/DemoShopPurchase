package com.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {


    Properties prop = null;
    InputStream input = Utils.class.getResource("//input.properties").openStream();

    public Utils() throws IOException {
    }

    public void ReadPropertiesFile() throws IOException {
        prop = new Properties();
        prop.load(input);
    }

    public String getURL(){
        return  prop.getProperty("URL");
    }
}
