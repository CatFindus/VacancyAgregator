package myorg.aggregator.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myorg.aggregator.vo.Vacancy;
import myorg.aggregator.vo.VacancyRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonResponceTestView extends JsonView{
    public JsonResponceTestView(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        super(req, resp);
    }

    @Override
    public void doSearch() {
        List<Vacancy> vacancies = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int rand = (int)(Math.random()*1000);
            vacancies.add(new Vacancy(String.format("Vacancy #%d",i+rand),
                    String.format("%d-%d",i*rand,i*2-rand),
                    String.format("City #%d",i+rand),
                    String.format("Company #%d",i+rand),
                    "SiteName",
                    String.format("Http://%d.ru",i+rand)));
        }
        update(vacancies);
    }

    @Override
    protected String getJsonFromRequest() throws IOException {
        return "not null string";
    }

    @Override
    protected VacancyRequest getPojoFromJson(String jsonString) throws IOException {
        return new VacancyRequest("not null string", true,false,false,false);
    }
}
