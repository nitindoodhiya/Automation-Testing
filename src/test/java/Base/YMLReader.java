package Base;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YMLReader {
    public String getXPath(String str, String filename){
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
        Map<String, String > map = yaml.load(inputStream);
        String xpath = map.get(str);
        return xpath;
    }

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
