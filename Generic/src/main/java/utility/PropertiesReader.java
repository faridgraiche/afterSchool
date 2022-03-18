package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {


    public static Properties readProperties(String path){
        Properties prop = new Properties();
        InputStream ism = null;
        try {
            ism = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ism);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ism.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
