package myorg.agregator.model;

import myorg.agregator.Aggregator;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ModelConstants {
    public static final String MODEL_REFERRER;
    public static final String MODEL_USER_AGENT;
    public static final String HH_URL_FORMAT;
    public static final String HH_SECTION_KEY;
    public static final String HH_SECTION_NAME;
    public static final String HH_TITLE_KEY;
    public static final String HH_TITLE_NAME;
    public static final String HH_URL_KEY;
    public static final String HH_URL_NAME;
    public static final String HH_CITY_KEY;
    public static final String HH_CITY_NAME;
    public static final String HH_SALARY_KEY;
    public static final String HH_SALARY_NAME;
    public static final String HH_HREF_ATTR_NAME;
    public static final String HH_SITE_NAME;
    public static final String HH_COMPANY_NAME;
    public static final String HH_COMPANY_KEY;
    public static final String HABR_URL_FORMAT;
    public static final String HABR_SECTION_NAME;
    public static final String HABR_TITLE_NAME;
    public static final String HABR_URL_START_NAME;
    public static final String HABR_URL_END_NAME;
    public static final String HABR_HREF_ATTR_NAME;
    public static final String HABR_SITE_NAME;
    public static final String HABR_CITY1_NAME;
    public static final String HABR_CITY2_NAME;
    public static final String HABR_SALARY_NAME;
    public static final String HABR_COMPANY_NAME;
    public static final String LINKEDIN_URL_FORMAT;
    public static final String LINKEDIN_COMPANY_NAME;
    public static final String LINKEDIN_TITLE_NAME;
    public static final String LINKEDIN_URL_NAME;
    public static final String LINKEDIN_SALARY_NAME;
    public static final String LINKEDIN_CITY_NAME;
    public static final String LINKEDIN_SECTION_NAME;
    public static final String LINKEDIN_HREF_ATTR_NAME;
    public static final String LINKEDIN_SITE_NAME;
    public static final String SUPERJOB_URL_FORMAT;
    public static final String SUPERJOB_SECTION_NAME;
    public static final String SUPERJOB_TITLE_NAME;
    public static final String SUPERJOB_URL_NAME;
    public static final String SUPERJOB_HREF_ATTR_NAME;
    public static final String SUPERJOB_CITY_NAME;
    public static final String SUPERJOB_SALARY_NAME;
    public static final String SUPERJOB_COMPANY_NAME;
    public static final String SUPERJOB_SITE_NAME;
    public static final String LOGGER_START_GETVACANCIES;
    public static final String LOGGER_END_GETVACANCIES;
    public static final String LOGGER_IOERROR_GETVACANCIES;
    public static final String LOGGER_START_DOSEARCH;
    public static final String LOGGER_END_DOSEARCH;
    public static final String LOGGER_WARN_DOSEARCH;
    public static final String LOGGER_DEBUG_DOSEARCH;
    public static final String LOGGER_ERROR_MODEL_CONSTRUCTOR;
    public static final String LOGGER_DEBUG_VACANCY_CONSTRUCTOR;

    static  {
        Properties properties = new Properties();
        try(InputStream is = Aggregator.class.getClassLoader().getResource("model.properties").openStream()) {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MODEL_REFERRER=properties.getProperty("MODEL_REFERRER");  //"http://www.google.com";
        MODEL_USER_AGENT=properties.getProperty("MODEL_USER_AGENT");  //"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36";
        HH_URL_FORMAT=properties.getProperty("HH_URL_FORMAT");  //"https://hh.ru/search/vacancy?text=java+%s&salary=&ored_clusters=true&area=2&hhtmFrom=vacancy_search_list&page=%d&items_on_page=20";
        HH_SECTION_KEY=properties.getProperty("HH_SECTION_KEY");  //"data-qa";
        HH_CITY_KEY=properties.getProperty("HH_CITY_KEY");  //"data-qa";
        HH_TITLE_KEY=properties.getProperty("HH_TITLE_KEY");  //"data-qa";
        HH_SALARY_KEY=properties.getProperty("HH_SALARY_KEY");  //"data-qa";
        HH_URL_KEY=properties.getProperty("HH_URL_KEY");  //"data-qa";
        HH_SECTION_NAME=properties.getProperty("HH_SECTION_NAME");  //"vacancy-serp__vacancy vacancy";
        HH_CITY_NAME=properties.getProperty("HH_CITY_NAME");  //"vacancy-serp__vacancy-address";
        HH_TITLE_NAME=properties.getProperty("HH_TITLE_NAME");  //"serp-item__title";
        HH_URL_NAME=properties.getProperty("HH_URL_NAME");  //"serp-item__title";
        HH_SALARY_NAME=properties.getProperty("HH_SALARY_NAME");  //"vacancy-serp__vacancy-compensation";
        HH_HREF_ATTR_NAME=properties.getProperty("HH_HREF_ATTR_NAME");  //"href";
        HH_SITE_NAME=properties.getProperty("HH_SITE_NAME");  //"https://hh.ru";
        HH_COMPANY_KEY=properties.getProperty("HH_COMPANY_KEY");  //"data-qa";
        HH_COMPANY_NAME=properties.getProperty("HH_COMPANY_NAME");  //"vacancy-serp__vacancy-employer";
        HABR_URL_FORMAT=properties.getProperty("HABR_URL_FORMAT");  //"https://career.habr.com/vacancies?page=%d&q=%s&type=all";
        HABR_SECTION_NAME=properties.getProperty("HABR_SECTION_NAME");  //"vacancy-card__info";
        HABR_TITLE_NAME=properties.getProperty("HABR_TITLE_NAME");  //"vacancy-card__title";
        HABR_URL_START_NAME=properties.getProperty("HABR_URL_START_NAME");  //"https://career.habr.com";
        HABR_URL_END_NAME=properties.getProperty("HABR_URL_END_NAME");  //"vacancy-card__title-link";
        HABR_HREF_ATTR_NAME=properties.getProperty("HABR_HREF_ATTR_NAME");  //"href";
        HABR_SITE_NAME=properties.getProperty("HABR_SITE_NAME");  //"https://career.habr.com";
        HABR_CITY1_NAME=properties.getProperty("HABR_CITY1_NAME");  //"vacancy-card__meta";
        HABR_CITY2_NAME=properties.getProperty("HABR_CITY2_NAME");  //"link-comp link-comp--appearance-dark";
        HABR_COMPANY_NAME=properties.getProperty("HABR_COMPANY_NAME");  //"vacancy-card__company";
        HABR_SALARY_NAME=properties.getProperty("HABR_SALARY_NAME");  //"basic-salary";
        LINKEDIN_URL_FORMAT=properties.getProperty("LINKEDIN_URL_FORMAT");  //"https://www.linkedin.com/jobs/search?keywords=%s&location=Russia&geoId=101728296&trk=public_jobs_jobs-search-bar_search-submit&position=1&pageNum=%d";
        LINKEDIN_SECTION_NAME=properties.getProperty("LINKEDIN_SECTION_NAME");  //"base-card relative w-full hover:no-underline focus:no-underline base-card--link base-search-card base-search-card--link job-search-card";
        LINKEDIN_COMPANY_NAME=properties.getProperty("LINKEDIN_COMPANY_NAME");  //"base-search-card__subtitle";
        LINKEDIN_CITY_NAME=properties.getProperty("LINKEDIN_CITY_NAME");  //"job-search-card__location";
        LINKEDIN_TITLE_NAME=properties.getProperty("LINKEDIN_TITLE_NAME");  //"base-search-card__title";
        LINKEDIN_SALARY_NAME=properties.getProperty("LINKEDIN_SALARY_NAME");  //"";
        LINKEDIN_URL_NAME=properties.getProperty("LINKEDIN_URL_NAME");  //"base-card__full-link absolute top-0 right-0 bottom-0 left-0 p-0 z-[2]";
        LINKEDIN_HREF_ATTR_NAME=properties.getProperty("LINKEDIN_HREF_ATTR_NAME");  //"href";
        LINKEDIN_SITE_NAME=properties.getProperty("LINKEDIN_SITE_NAME");  //"https://www.linkedin.com";
        SUPERJOB_URL_FORMAT=properties.getProperty("SUPERJOB_URL_FORMAT");  //"https://www.superjob.ru/vacancy/search/?keywords=%s&page=%d";
        SUPERJOB_SECTION_NAME=properties.getProperty("SUPERJOB_SECTION_NAME");  //"_1KqxI f-test-vacancy-item _3HN9U bxeoD nz9w6 _3b4en _2ozQ8";
        SUPERJOB_TITLE_NAME=properties.getProperty("SUPERJOB_TITLE_NAME");  //"_3xQyu _3h-Il Ev2_p _3vg36 _133uk rPK4q _2ASNn bb-JF";
        SUPERJOB_URL_NAME=properties.getProperty("SUPERJOB_URL_NAME");  //"_1IHWd";
        SUPERJOB_HREF_ATTR_NAME=properties.getProperty("SUPERJOB_HREF_ATTR_NAME");  //"href";
        SUPERJOB_COMPANY_NAME=properties.getProperty("SUPERJOB_COMPANY_NAME");  //"_3nMqD f-test-text-vacancy-item-company-name _3uSoo rPK4q _2ASNn Mq4Ti MFNgx";
        SUPERJOB_SALARY_NAME=properties.getProperty("SUPERJOB_SALARY_NAME");  //"f-test-text-company-item-salary";
        SUPERJOB_SITE_NAME=properties.getProperty("SUPERJOB_SITE_NAME");  //"https://www.superjob.ru";
        SUPERJOB_CITY_NAME=properties.getProperty("SUPERJOB_CITY_NAME");  //"f-test-text-company-item-location";
        LOGGER_START_GETVACANCIES=properties.getProperty("LOGGER_START_GETVACANCIES");
        LOGGER_END_GETVACANCIES=properties.getProperty("LOGGER_END_GETVACANCIES");
        LOGGER_IOERROR_GETVACANCIES=properties.getProperty("LOGGER_IOERROR_GETVACANCIES");
        LOGGER_START_DOSEARCH= properties.getProperty("LOGGER_START_DOSEARCH");
        LOGGER_END_DOSEARCH=properties.getProperty("LOGGER_END_DOSEARCH");
        LOGGER_WARN_DOSEARCH=properties.getProperty("LOGGER_WARN_DOSEARCH");
        LOGGER_DEBUG_DOSEARCH= properties.getProperty("LOGGER_DEBUG_DOSEARCH");
        LOGGER_ERROR_MODEL_CONSTRUCTOR=properties.getProperty("LOGGER_ERROR_MODEL_CONSTRUCTOR");
        LOGGER_DEBUG_VACANCY_CONSTRUCTOR=properties.getProperty("LOGGER_DEBUG_VACANCY_CONSTRUCTOR");
    }

    private ModelConstants() {
    }
}
