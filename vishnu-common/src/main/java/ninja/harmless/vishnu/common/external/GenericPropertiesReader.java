package ninja.harmless.vishnu.common.external;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
public class GenericPropertiesReader {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public <T> List<T> read(String resourceName, Class<T> type) {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(resourceName));
        } catch (IOException e) {
            logger.error("Could not read countries.properties");
        }

        List<T> l = new ArrayList<>();

        try {
            Constructor c = type.getConstructor(String.class, String.class);
            properties.forEach((k,v) -> {
                try {
                    l.add((T) c.newInstance((String) v, (String) k));
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        } catch (NoSuchMethodException e) {
            logger.error("only tuple string constructors are allowed");
        }

        return l;
    }
}
