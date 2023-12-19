package myorg.agregator.model;

import myorg.agregator.vo.Vacancy;

import java.util.List;

public interface Strategy {
   List<Vacancy> getVacancies(String searchString);
}
