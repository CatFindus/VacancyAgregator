package myorg.aggregator.view;

import myorg.aggregator.Aggregator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ViewConstants {
    public static final String HTMLVIEW_CHARSET;
    public static final String HTMLVIEW_REMOVABLE_CLASSNAME;
    public static final String HTMLVIEW_REMOVABLE_ATTR;
    public static final String HTMLVIEW_REMOVABLE_BLOCKS_CLASSNAME;
    public static final String HTMLVIEW_ADD_ATTR;
    public static final String HTMLVIEW_ADD_CITY_CLASSNAME;
    public static final String HTMLVIEW_ADD_SALARY_CLASSNAME;
    public static final String HTMLVIEW_ADD_COMPANY_CLASSNAME;
    public static final String HTML_FILE_ADDR;
    public static final String HTML_BACKUP_ADDR;
    public static final String LOGGER_DEBUG_CONSTRUCTOR_HTMLVIEW;
    public static final String LOGGER_ERROR_CONSTRUCTOR_HTMLVIEW;
    public static final String LOGGER_ERROR_UPDATE_HTMLVIEW;
    public static final String LOGGER_TRACE_START_METHOD;
    public static final String LOGGER_TRACE_END_METHOD;
    public static final String LOGGER_DEBUG_INPUT_METHOD;
    public static final String LOGGER_DEBUG_RETURN_METHOD;
    public static final String LOGEER_ERROR_GETUPDATEDFILECONTENT;
    public static final String LOGGER_WARN_GETUPDATEDFILECONTENT;
    private static final Logger logger = LoggerFactory.getLogger(ViewConstants.class);

    static {
        Properties properties = new Properties();
        try(InputStream is = Aggregator.class.getClassLoader().getResource("view.properties").openStream()) {
            properties.load(is);
        } catch (IOException e) {
            //logger.error("Error to access properties file ViewConstants");
        }
        HTMLVIEW_CHARSET= properties.getProperty("HTMLVIEW_CHARSET");
        HTMLVIEW_REMOVABLE_CLASSNAME= properties.getProperty("HTMLVIEW_REMOVABLE_CLASSNAME");
        HTMLVIEW_REMOVABLE_BLOCKS_CLASSNAME= properties.getProperty("HTMLVIEW_REMOVABLE_BLOCKS_CLASSNAME");
        HTMLVIEW_REMOVABLE_ATTR= properties.getProperty("HTMLVIEW_REMOVABLE_ATTR");
        HTMLVIEW_ADD_ATTR= properties.getProperty("HTMLVIEW_ADD_ATTR");
        HTMLVIEW_ADD_COMPANY_CLASSNAME= properties.getProperty("HTMLVIEW_ADD_COMPANY_CLASSNAME");
        HTMLVIEW_ADD_CITY_CLASSNAME= properties.getProperty("HTMLVIEW_ADD_CITY_CLASSNAME");
        HTMLVIEW_ADD_SALARY_CLASSNAME= properties.getProperty("HTMLVIEW_ADD_SALARY_CLASSNAME");
        HTML_FILE_ADDR= properties.getProperty("HTML_FILE_ADDR");
        HTML_BACKUP_ADDR= properties.getProperty("HTML_BACKUP_ADDR");
        LOGGER_DEBUG_CONSTRUCTOR_HTMLVIEW= properties.getProperty("LOGGER_DEBUG_CONSTRUCTOR_HTMLVIEW");
        LOGGER_ERROR_CONSTRUCTOR_HTMLVIEW= properties.getProperty("LOGGER_ERROR_CONSTRUCTOR_HTMLVIEW");
        LOGGER_ERROR_UPDATE_HTMLVIEW = properties.getProperty("LOGGER_ERROR_UPDATE_HTMLVIEW");
        LOGGER_DEBUG_RETURN_METHOD = properties.getProperty("LOGGER_DEBUG_RETURN_METHOD");
        LOGGER_TRACE_START_METHOD = properties.getProperty("LOGGER_TRACE_START_METHOD");
        LOGGER_DEBUG_INPUT_METHOD = properties.getProperty("LOGGER_DEBUG_INPUT_METHOD");
        LOGGER_TRACE_END_METHOD = properties.getProperty("LOGGER_TRACE_END_METHOD");
        LOGEER_ERROR_GETUPDATEDFILECONTENT= properties.getProperty("LOGEER_ERROR_GETUPDATEDFILECONTENT");
        LOGGER_WARN_GETUPDATEDFILECONTENT= properties.getProperty("LOGGER_WARN_GETUPDATEDFILECONTENT");
    }
    private ViewConstants() {}
}
