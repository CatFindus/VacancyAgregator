package myorg.agregator.model;

import myorg.agregator.vo.Vacancy;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private final Logger logger = LoggerFactory.getLogger(HHStrategy.class);

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        logger.trace(ModelConstants.LOGGER_START_GETVACANCIES,this.getClass().getEnclosingMethod().getName(),searchString);
        List<Vacancy> vacancies = new ArrayList<>();
        boolean hasVacacies = true;
        for (int i = 0; hasVacacies; i++) {
            try {
                Document document = ModelDataLoader.getDocument(searchString, i,ModelConstants.HH_URL_FORMAT);
                List<Element> elements = document.getElementsByAttributeValueContaining(ModelConstants.HH_SECTION_KEY,ModelConstants.HH_SECTION_NAME);
                if(elements.isEmpty()) break;
                else {
                    for (Element element : elements) {
                        String title = element.getElementsByClass(ModelConstants.HH_TITLE_NAME).text();
                        String url = element.getElementsByAttributeValue(ModelConstants.HH_URL_KEY, ModelConstants.HH_URL_NAME).attr(ModelConstants.HH_HREF_ATTR_NAME);
                        String city = element.getElementsByAttributeValue(ModelConstants.HH_CITY_KEY, ModelConstants.HH_CITY_NAME).text();
                        String salary = element.getElementsByAttributeValue(ModelConstants.HH_SALARY_KEY, ModelConstants.HH_SALARY_NAME).text();
                        String company = element.getElementsByAttributeValue(ModelConstants.HH_COMPANY_KEY, ModelConstants.HH_COMPANY_NAME).text();
                        Vacancy vacancy = new Vacancy(title,salary,city,company, ModelConstants.HH_SITE_NAME, url);
                        vacancies.add(vacancy);
                    }
                }
            } catch (IOException e) {
                hasVacacies=false;
                logger.error(ModelConstants.LOGGER_IOERROR_GETVACANCIES, this.getClass().getEnclosingMethod().getName());
            }
        }
        logger.trace(ModelConstants.LOGGER_END_GETVACANCIES, this.getClass().getEnclosingMethod().getName(),vacancies.size());
        return vacancies;
    }
}
