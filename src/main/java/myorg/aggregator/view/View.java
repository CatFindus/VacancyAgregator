package myorg.aggregator.view;

import myorg.aggregator.Controller;
import myorg.aggregator.vo.Vacancy;

import java.util.List;

public interface View {
    void update(List<Vacancy> vacancies);
    void setController(Controller controller);
}
