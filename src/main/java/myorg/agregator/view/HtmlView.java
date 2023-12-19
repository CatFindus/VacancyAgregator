package myorg.agregator.view;

import myorg.agregator.Controller;
import myorg.agregator.model.ModelConstants;
import myorg.agregator.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class HtmlView implements View{
private Controller controller;
private final String filePath;

    public HtmlView() {
        filePath=ViewConstants.HTML_FILE_ADDR;
        if(Files.notExists(Paths.get(filePath))) {
            try {
                Files.copy(Path.of(ViewConstants.HTML_BACKUP_ADDR), Path.of(ViewConstants.HTML_FILE_ADDR));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //String s=this.getClass().getPackage().getName().replaceAll("\\.", "/");
        //filePath="src/main/java/"+s+"/vacancies.html";
    }

    @Override
    public void update(List<Vacancy> vacancies)
    {
        try {
            String s = getUpdatedFileContent(vacancies);
            updateFile(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void userCitySelectEmulationMethod(String request) {
        controller.doSearch(request);
    }
    @Override
    public void setController(Controller controller) {
        this.controller=controller;
    }
    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), ViewConstants.HTMLVIEW_CHARSET);
    }
    private String getUpdatedFileContent(List<Vacancy> vacancies) {
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
            return doc.html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Some exception occurred";
    }
    private void updateFile(String string) throws IOException {
        try(FileOutputStream out = new FileOutputStream(filePath);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
            writer.write(string);
            writer.flush();
        }
    }

}
