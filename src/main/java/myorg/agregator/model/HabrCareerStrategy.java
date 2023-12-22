package myorg.agregator.model;

import myorg.agregator.vo.Vacancy;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerStrategy implements Strategy{
    private final Logger logger = LoggerFactory.getLogger(HabrCareerStrategy.class);
    @Override
    public List<Vacancy> getVacancies(String searchString) {
    String methodName = new Throwable().getStackTrace()[0].getMethodName();
        logger.trace(ModelConstants.LOGGER_START_GETVACANCIES,methodName,searchString);
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            for (int i = 1; true; i++) {
                String request=String.format(ModelConstants.HABR_URL_FORMAT, i, searchString.replaceAll(" ", "+"));
                Document document = ModelDataLoader.getDocument(request);
                List<Element> elements = document.getElementsByClass(ModelConstants.HABR_SECTION_NAME);
                if (elements.isEmpty()) break;
                else {
                    for (Element element : elements) {
                    Element titleElement = element.getElementsByClass(ModelConstants.HABR_TITLE_NAME).get(0);
                    String title = titleElement.text();
                    String url = ModelConstants.HABR_URL_START_NAME+element.getElementsByClass(ModelConstants.HABR_URL_END_NAME).attr(ModelConstants.HABR_HREF_ATTR_NAME);
                    String company = element.getElementsByClass(ModelConstants.HABR_COMPANY_NAME).text();
                    String city =  element.getElementsByClass(ModelConstants.HABR_CITY1_NAME).get(0).getElementsByClass(ModelConstants.HABR_CITY2_NAME).text();
                    String salary = element.getElementsByClass(ModelConstants.HABR_SALARY_NAME).text();
                    String siteName = ModelConstants.HABR_SITE_NAME;
                    Vacancy vacancy = new Vacancy(title,salary,city,company,siteName,url);
                    vacancies.add(vacancy);
                    }
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
        return "HABRCareerStrategy";
    }

}
