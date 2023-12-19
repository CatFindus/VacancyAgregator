package myorg.agregator.model;

import myorg.agregator.view.View;
import myorg.agregator.vo.Vacancy;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {
        if (view == null || providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }
        this.view = view;
        this.providers = providers;
    }

    public void doSearch(String searchRequest) {
        List<Vacancy> vacancies = new ArrayList<>();
        for (Provider provider : providers) {
            List<Vacancy> providerVacancies = provider.getVacancies(searchRequest);
            if(providerVacancies!=null) vacancies.addAll(providerVacancies);
        }
        view.update(vacancies);
    }
}
