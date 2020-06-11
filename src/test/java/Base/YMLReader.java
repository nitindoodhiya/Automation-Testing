package base;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

public class YMLReader {
    //returns the xpath of required element given by name "name" and will search in "filename".yml
    //object_repository
    public String getXPath(String name, String filename){
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
        Map<String, String > map = yaml.load(inputStream);      //map for storing the key-value pair of yaml file
        String xpath = map.get(name);
        return xpath;
    }

    //returns value of key in map of map in yml
    public String getInfo(String key1,String key2, String filename){
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(filename);
        Map<String, Map<String,String > > map = yaml.load(inputStream);
        String res = map.get(key1).get(key2);
        return res;
    }
}
