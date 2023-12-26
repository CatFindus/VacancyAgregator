package myorg.aggregator.model;

import myorg.aggregator.vo.Vacancy;

import java.util.List;

public interface Strategy {
   List<Vacancy> getVacancies(String searchString);
   String getName();
}
