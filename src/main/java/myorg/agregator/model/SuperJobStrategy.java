package myorg.agregator.model;

import myorg.agregator.vo.Vacancy;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SuperJobStrategy implements Strategy{
    private final Logger logger = LoggerFactory.getLogger(SuperJobStrategy.class);
    @Override
    public List<Vacancy> getVacancies(String searchString) {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        logger.trace(ModelConstants.LOGGER_START_GETVACANCIES,methodName,searchString);
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            for (int i = 1; true; i++) {
                String request = String.format(ModelConstants.SUPERJOB_URL_FORMAT, searchString.replaceAll(" ", "%20"), i);
                Document document = ModelDataLoader.getDocument(request);
                List<Element> elements = document.getElementsByClass(ModelConstants.SUPERJOB_SECTION_NAME);
                if (elements.isEmpty()) break;
                for (Element element: elements) {
                    Element titleElement = element.getElementsByClass(ModelConstants.SUPERJOB_TITLE_NAME).first();
                    String title = titleElement.text();
                    String url = ModelConstants.SUPERJOB_SITE_NAME+element.getElementsByClass(ModelConstants.SUPERJOB_URL_NAME).attr("href");
                    String company = element.getElementsByClass(ModelConstants.SUPERJOB_COMPANY_NAME).text();
                    String city =  element.getElementsByClass(ModelConstants.SUPERJOB_CITY_NAME).first().text();
                    String salary = element.getElementsByClass(ModelConstants.SUPERJOB_SALARY_NAME).get(0).text();
                    String siteName = ModelConstants.SUPERJOB_SITE_NAME;
                    Vacancy vacancy = new Vacancy(title,salary,city,company,siteName,url);
                    if (!vacancies.contains(vacancy)) vacancies.add(vacancy);
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
        return "SuperJobStrategy";
    }
}
