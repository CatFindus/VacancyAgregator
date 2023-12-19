package myorg.agregator.view;

import myorg.agregator.Aggregator;

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

    static {
        Properties properties = new Properties();
        try(InputStream is = Aggregator.class.getClassLoader().getResource("view.properties").openStream()) {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        HTMLVIEW_CHARSET="UTF-8";
        HTMLVIEW_REMOVABLE_CLASSNAME="template";
        HTMLVIEW_REMOVABLE_BLOCKS_CLASSNAME="vacancy";
        HTMLVIEW_REMOVABLE_ATTR="style";
        HTMLVIEW_ADD_ATTR="href";
        HTMLVIEW_ADD_COMPANY_CLASSNAME="companyName";
        HTMLVIEW_ADD_CITY_CLASSNAME="city";
        HTMLVIEW_ADD_SALARY_CLASSNAME="salary";
        HTML_FILE_ADDR="src/main/resources/vacancies.html";
        HTML_BACKUP_ADDR="src/main/resources/vacancies.html";
    }
    private ViewConstants() {}
}
