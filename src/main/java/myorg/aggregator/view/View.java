package myorg.aggregator.view;

import myorg.aggregator.controller.Controller;
import myorg.aggregator.vo.Vacancy;
import myorg.aggregator.vo.VacancyRequest;

import java.util.List;

public interface View {
    void update(List<Vacancy> vacancies);
    void setController(Controller controller);
    VacancyRequest getVacancyRequest();
    void doSearch();
}
