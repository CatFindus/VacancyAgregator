package myorg.aggregator.model;

import myorg.aggregator.vo.Vacancy;

import java.util.List;

public class Provider {
    private Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Vacancy> getVacancies(String searchString) {
        return strategy.getVacancies(searchString);
    }
}
