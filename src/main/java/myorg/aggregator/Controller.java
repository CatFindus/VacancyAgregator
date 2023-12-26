package myorg.aggregator;

import myorg.aggregator.model.Model;


public class Controller {
    private Model model;

    public Controller(Model model) {
        if (model==null) throw new IllegalArgumentException();
        this.model = model;
    }
    public void doSearch(String searchRequest) {
        model.doSearch(searchRequest);
    }
}
