    package myorg.aggregator;


    import myorg.aggregator.model.*;
    import myorg.aggregator.view.HtmlView;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

    public class Aggregator {
        private static final Logger logger = LoggerFactory.getLogger(Aggregator.class);
    public static void main(String[] args) {
        logger.info("Running app");
        HtmlView view = new HtmlView();
        Model model = new Model(view, new Provider(new LinkedinStrategy()));//, new Provider(new SuperJobStrategy()), new Provider(new HHStrategy()), new Provider(new HabrCareerStrategy()));
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userEmulationMethod("java developer");  //java developer
        logger.info("Ending app");

    }
}
