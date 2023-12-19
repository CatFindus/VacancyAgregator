package myorg.agregator.view;

import myorg.agregator.Controller;
import myorg.agregator.vo.Vacancy;

import java.util.List;

public interface View {
    void update(List<Vacancy> vacancies);
    void setController(Controller controller);
}
