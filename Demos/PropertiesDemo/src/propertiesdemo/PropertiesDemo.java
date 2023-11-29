/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertiesdemo;

import java.util.Properties;

/**
 *
 * @author alexa
 */
public class PropertiesDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Properties properties = System.getProperties();
//        for (String key : properties.stringPropertyNames()) {
//            System.out.println(key + " = " + properties.getProperty(key));
//        }
        properties.list(System.out);
    }

}
