package myorg.aggregator.model;

import myorg.aggregator.view.View;
import myorg.aggregator.vo.Vacancy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private final Logger logger = LoggerFactory.getLogger(Model.class);
    private final View view;
    private final Strategy[] strategies;

    public Model(View view, Strategy... strategies) {
        if (view == null || strategies == null || strategies.length == 0) {
            logger.error(ModelConstants.LOGGER_ERROR_MODEL_CONSTRUCTOR, view, strategies);
            throw new IllegalArgumentException();
        }
        this.view = view;
        this.strategies = strategies;
    }

    public void doSearch(String searchRequest) {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        logger.trace(ModelConstants.LOGGER_START_DOSEARCH, methodName, searchRequest);
        List<Vacancy> vacancies = new ArrayList<>();
        for (Strategy strategy : strategies) {
            List<Vacancy> providerVacancies = strategy.getVacancies(searchRequest);
            if(providerVacancies!=null && !providerVacancies.isEmpty()) vacancies.addAll(providerVacancies);
            else logger.warn(ModelConstants.LOGGER_WARN_DOSEARCH, strategy.getName());
        }
        logger.info(ModelConstants.LOGGER_INFO_DOSEARCH, searchRequest, vacancies.size());
        view.update(vacancies);
        logger.debug(ModelConstants.LOGGER_DEBUG_DOSEARCH, vacancies);
        logger.trace(ModelConstants.LOGGER_END_DOSEARCH, methodName);
    }
}
