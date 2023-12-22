package myorg.agregator.model;

import myorg.agregator.view.View;
import myorg.agregator.vo.Vacancy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private final Logger logger = LoggerFactory.getLogger(Model.class);
    private final View view;
    private final Provider[] providers;

    public Model(View view, Provider... providers) {
        if (view == null || providers == null || providers.length == 0) {
            logger.error(ModelConstants.LOGGER_ERROR_MODEL_CONSTRUCTOR, view, providers);
            throw new IllegalArgumentException();
        }
        this.view = view;
        this.providers = providers;
    }

    public void doSearch(String searchRequest) {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        logger.trace(ModelConstants.LOGGER_START_DOSEARCH, methodName, searchRequest);
        List<Vacancy> vacancies = new ArrayList<>();
        for (Provider provider : providers) {
            List<Vacancy> providerVacancies = provider.getVacancies(searchRequest);
            if(providerVacancies!=null && !providerVacancies.isEmpty()) vacancies.addAll(providerVacancies);
            else logger.warn(ModelConstants.LOGGER_WARN_DOSEARCH, provider.getStrategy().getName());
        }
        logger.info(ModelConstants.LOGGER_INFO_DOSEARCH, searchRequest, vacancies.size());
        view.update(vacancies);
        logger.debug(ModelConstants.LOGGER_DEBUG_DOSEARCH, vacancies);
        logger.trace(ModelConstants.LOGGER_END_DOSEARCH, methodName);
    }
}
