    package myorg.agregator;


    import myorg.agregator.model.*;
    import myorg.agregator.view.HtmlView;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

    public class Aggregator {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Aggregator.class);
        for (int i = 0; i < 100; i++) {
            logger.debug("debug Message");
            logger.info("info Message");
            logger.trace("trace Message");
            logger.warn("warning Message");
            logger.error("error Message {} {} {}", 1000, "dfyg", 102);
        }

        //System.out.println(ModelConstants.MODEL_REFERRER);
        //HtmlView view = new HtmlView();
        //Model model = new Model(view, new Provider(new HabrCareerStrategy()));
                                        //new Provider(new HabrCareerStrategy())
                                        //new Provider(new SuperJobStrategy()));
        //Controller controller = new Controller(model);
        //view.setController(controller);
        //view.userCitySelectEmulationMethod("java developer");

    }
}
