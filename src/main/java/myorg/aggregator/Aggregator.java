    package myorg.aggregator;


    import myorg.aggregator.controller.Controller;
    import myorg.aggregator.model.*;
    import myorg.aggregator.view.HtmlView;
    import myorg.aggregator.vo.VacancyRequest;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

    public class Aggregator {
        private static final Logger logger = LoggerFactory.getLogger(Aggregator.class);
    public static void main(String[] args) {
        logger.info("Running app");
        VacancyRequest vacancyRequest = new VacancyRequest();
        vacancyRequest.setSearchRequest("java developer");
        vacancyRequest.setHabrSearch(true);
        HtmlView view = new HtmlView(vacancyRequest);
        Model model = ModelFabric.getModel(view);
        Controller controller = new Controller(model);
        view.setController(controller);
        logger.info("Ending app");

    }
}
