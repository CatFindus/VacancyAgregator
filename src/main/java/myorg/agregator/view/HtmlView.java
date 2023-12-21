package myorg.agregator.view;

import myorg.agregator.Controller;
import myorg.agregator.model.ModelConstants;
import myorg.agregator.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class HtmlView implements View{
private Controller controller;
private final String filePath;
private final Logger logger = LoggerFactory.getLogger(HtmlView.class);
    public HtmlView() {
        filePath=ViewConstants.HTML_FILE_ADDR;
        logger.debug(ViewConstants.LOGGER_DEBUG_CONSTRUCTOR_HTMLVIEW, filePath);
        if(Files.notExists(Paths.get(filePath))) {
            try {
                Files.copy(Path.of(ViewConstants.HTML_BACKUP_ADDR), Path.of(ViewConstants.HTML_FILE_ADDR));
            } catch (IOException e) {
                logger.error(ViewConstants.LOGGER_DEBUG_CONSTRUCTOR_HTMLVIEW, filePath);
            }
        }
        //String s=this.getClass().getPackage().getName().replaceAll("\\.", "/");
        //filePath="src/main/java/"+s+"/vacancies.html";
    }

    @Override
    public void update(List<Vacancy> vacancies)
    {
        logger.trace(ViewConstants.LOGGER_TRACE_START_METHOD, this.getClass().getEnclosingMethod().getName());
        try {
            String s = getUpdatedFileContent(vacancies);
            updateFile(s);
        } catch (IOException e) {
            logger.error(ViewConstants.LOGGER_ERROR_UPDATE_HTMLVIEW, this.getClass().getEnclosingMethod().getName());
        }
        logger.trace(ViewConstants.LOGGER_TRACE_END_METHOD, this.getClass().getEnclosingMethod().getName());
    }
    public void userCitySelectEmulationMethod(String request) {
        logger.trace(ViewConstants.LOGGER_TRACE_START_METHOD, this.getClass().getEnclosingMethod().getName());
        controller.doSearch(request);
        logger.trace(ViewConstants.LOGGER_TRACE_END_METHOD, this.getClass().getEnclosingMethod().getName());
    }
    @Override
    public void setController(Controller controller) {
        logger.trace(ViewConstants.LOGGER_TRACE_START_METHOD, this.getClass().getEnclosingMethod().getName());
        this.controller=controller;
        logger.trace(ViewConstants.LOGGER_TRACE_END_METHOD, this.getClass().getEnclosingMethod().getName());
    }
    protected Document getDocument() throws IOException {
        logger.trace(ViewConstants.LOGGER_TRACE_START_METHOD, this.getClass().getEnclosingMethod().getName());
        Document document = Jsoup.parse(new File(filePath), ViewConstants.HTMLVIEW_CHARSET);
        logger.trace(ViewConstants.LOGGER_TRACE_END_METHOD, this.getClass().getEnclosingMethod().getName());
        return document;
    }
    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        logger.trace(ViewConstants.LOGGER_TRACE_START_METHOD, this.getClass().getEnclosingMethod().getName());
        logger.debug(ViewConstants.LOGGER_DEBUG_INPUT_METHOD, this.getClass().getEnclosingMethod().getName(), vacancies);
        try {
            Document doc = getDocument();
            Elements templateHidden = doc.getElementsByClass(ViewConstants.HTMLVIEW_REMOVABLE_CLASSNAME);
            Element template = templateHidden.clone().removeAttr(ViewConstants.HTMLVIEW_REMOVABLE_ATTR).removeClass(ViewConstants.HTMLVIEW_REMOVABLE_CLASSNAME).get(0);

            //remove all prev vacancies
            Elements prevVacancies = doc.getElementsByClass(ViewConstants.HTMLVIEW_REMOVABLE_BLOCKS_CLASSNAME);

            for (Element redundant : prevVacancies) {
                if (!redundant.hasClass(ViewConstants.HTMLVIEW_REMOVABLE_CLASSNAME)) {
                    redundant.remove();
                }
            }
            //add new vacancies
            for (Vacancy vacancy : vacancies) {
                Element vacancyElement = template.clone();
                Element vacancyLink = vacancyElement.getElementsByAttribute(ViewConstants.HTMLVIEW_ADD_ATTR).get(0);
                vacancyLink.appendText(vacancy.getTitle());
                vacancyLink.attr(ViewConstants.HTMLVIEW_ADD_ATTR, vacancy.getUrl());
                Element city = vacancyElement.getElementsByClass(ViewConstants.HTMLVIEW_ADD_CITY_CLASSNAME).get(0);
                city.appendText(vacancy.getCity());
                Element companyName = vacancyElement.getElementsByClass(ViewConstants.HTMLVIEW_ADD_COMPANY_CLASSNAME).get(0);
                companyName.appendText(vacancy.getCompanyName());
                Elements salaryEls = vacancyElement.getElementsByClass(ViewConstants.HTMLVIEW_ADD_SALARY_CLASSNAME);
                Element salary = salaryEls.get(0);
                salary.appendText(vacancy.getSalary());
                templateHidden.before(vacancyElement.outerHtml());
            }
            String htmlReturn = doc.html();
            logger.debug(ViewConstants.LOGGER_DEBUG_RETURN_METHOD, this.getClass().getEnclosingMethod().getName(), htmlReturn);
            logger.trace(ViewConstants.LOGGER_TRACE_END_METHOD, this.getClass().getEnclosingMethod().getName());
            return htmlReturn;
        } catch (IOException e) {
            logger.error(ViewConstants.LOGGER_ERROR_UPDATE_HTMLVIEW, this.getClass().getEnclosingMethod().getName());
        }
        logger.warn(ViewConstants.LOGGER_WARN_GETUPDATEDFILECONTENT, this.getClass().getEnclosingMethod().getName());
        return "";
    }
    private void updateFile(String string) throws IOException {
        logger.trace(ViewConstants.LOGGER_TRACE_START_METHOD, this.getClass().getEnclosingMethod().getName());
        try(FileOutputStream out = new FileOutputStream(filePath);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
            writer.write(string);
            writer.flush();
        }
        logger.trace(ViewConstants.LOGGER_TRACE_END_METHOD, this.getClass().getEnclosingMethod().getName());
    }

}
