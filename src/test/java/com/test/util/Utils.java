package com.test.util;

import java.io.*;
import java.util.Properties;

public class Utils {
    private Properties properties;

    public Utils() throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("input.properties"));
        properties = new Properties();
        properties.load(reader);
        reader.close();
    }

    public String applicationURL() {
        return properties.getProperty("URL");
    }

}
