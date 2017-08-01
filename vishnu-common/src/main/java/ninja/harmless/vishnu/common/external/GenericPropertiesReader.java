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

    @SuppressWarnings("unchecked")
    public <T> List<T> read(String resourceName, Class<T> type) {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(resourceName));
        } catch (IOException e) {
            logger.error("Could not read {}", resourceName);
        }

        List<T> l = new ArrayList<>();

        Constructor[] constructors = type.getConstructors();

        if (constructors.length != 2) {
            throw new IllegalArgumentException("Only classes with one constructor are allowed");
        }

        Constructor c = null;

        if (constructors[0].getParameterTypes().length != 0) {
            c = constructors[0];
        } else {
            c = constructors[1];
        }

        Class[] params = c.getParameterTypes();
        Constructor finalC = c;
        properties.forEach((k, v) -> {
            try {
                if (params[0] == Integer.class) {
                    Integer integer = Integer.valueOf((String) v);
                    l.add((T) finalC.newInstance(integer, k));
                } else if (params[1] == Integer.class) {
                    Integer integer = Integer.valueOf((String) v);
                    l.add((T) finalC.newInstance(k, integer));
                } else {
                    l.add((T) finalC.newInstance(v, k));
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                logger.error("Could not instantiate {0} with {1}, {2}", type.getSimpleName(), v, k);
            }
        });

        return l;
    }
}
