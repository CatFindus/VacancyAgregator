package myorg.aggregator.model;

import myorg.aggregator.vo.Vacancy;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkedinStrategy implements Strategy{
    private final Logger logger = LoggerFactory.getLogger(LinkedinStrategy.class);
    @Override
    public List<Vacancy> getVacancies(String searchString) {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        logger.trace(ModelConstants.LOGGER_START_GETVACANCIES,methodName,searchString);
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            for (int i = 0; i<1; i++) {
                String request = String.format(ModelConstants.LINKEDIN_URL_FORMAT, searchString.replaceAll(" ", "+"), i);
                Document document = ModelDataLoader.getDocument(request);
                List<Element> elements = document.getElementsByClass(ModelConstants.LINKEDIN_SECTION_NAME);
                if (elements.isEmpty()) break;
                for (Element element: elements) {
                    Element titleElement = element.getElementsByClass(ModelConstants.LINKEDIN_TITLE_NAME).first();
                    String title = titleElement.text();
                    String url = element.getElementsByClass(ModelConstants.LINKEDIN_URL_NAME).attr(ModelConstants.LINKEDIN_HREF_ATTR_NAME);
                    String company = element.getElementsByClass(ModelConstants.LINKEDIN_COMPANY_NAME).text();
                    String city =  element.getElementsByClass(ModelConstants.LINKEDIN_CITY_NAME).get(0).text();
                    String salary;
                        if(ModelConstants.LINKEDIN_SALARY_NAME.isEmpty()) salary = ModelConstants.LINKEDIN_SALARY_NAME;
                        else salary = element.getElementsByClass(ModelConstants.LINKEDIN_SALARY_NAME).text();
                    Vacancy vacancy = new Vacancy(title,salary,city,company,ModelConstants.LINKEDIN_SITE_NAME,url);
                    vacancies.add(vacancy);
                }
            }
        } catch (IOException e) {
            logger.error(ModelConstants.LOGGER_IOERROR_GETVACANCIES, methodName);
        }
        logger.trace(ModelConstants.LOGGER_END_GETVACANCIES, methodName,vacancies.size());
        return vacancies;
    }

    @Override
    public String getName() {
        return "LinkedInStrategy";
    }
}
