package myorg.aggregator.model;

import myorg.aggregator.view.View;
import myorg.aggregator.vo.VacancyRequest;

import java.util.ArrayList;
import java.util.List;

public final class ModelFabric {
    private ModelFabric() {
    }

    public static Model getModel(View view) {
        Model model = null;
        List<Strategy> strategies = new ArrayList<>();
        if (view.getVacancyRequest().isHabrSearch()) strategies.add(new HabrCareerStrategy());
        if (view.getVacancyRequest().isHhSearch()) strategies.add(new HHStrategy());
        if (view.getVacancyRequest().isLiSearch()) strategies.add(new LinkedinStrategy());
        if (view.getVacancyRequest().isRrSearch()) strategies.add(new SuperJobStrategy());
            model = new Model(view, strategies.toArray(new Strategy[strategies.size()]));
        return model;
    }
}
