package myorg.aggregator.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import myorg.aggregator.controller.Controller;
import myorg.aggregator.vo.Vacancy;
import myorg.aggregator.vo.VacancyRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

public class JsonView implements View{
    private static final Logger logger = LoggerFactory.getLogger(JsonView.class);
    private Controller controller;
    private final ObjectMapper objectMapper;
    private final HttpServletRequest req;
    private final HttpServletResponse resp;
    @Getter
    private final VacancyRequest vacancyRequest;
    public JsonView(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        objectMapper=new ObjectMapper();
        this.req=req;
        this.resp=resp;
        String jsonRequest = getJsonFromRequest();
        if(jsonRequest.isEmpty() || (vacancyRequest=getPojoFromJson(jsonRequest))==null) {
            throw new IOException(ViewConstants.LOGGER_JSONVIEW_WARN_ERROR_TO_CREATE_VACANCYREQUEST);
        }
    }
    @Override
    public void update(List<Vacancy> vacancies) {
        try(PrintWriter out = resp.getWriter()) {
            String jsonString = objectMapper.writeValueAsString(vacancies);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.print(jsonString);
            out.flush();
        } catch (IOException e) {
            logger.error(ViewConstants.LOGGER_JSONVIEW_ERROR_CREATE_JSON_RESPONCE_DATA);
            try {
                resp.sendError(500, ViewConstants.LOGGER_JSONVIEW_ERROR_CREATE_JSON_RESPONCE_DATA);
            } catch (IOException ex) {
                logger.warn(ViewConstants.LOGGER_JSONVIEW_WARN_SEND_ERROR);
            }
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller=controller;
    }
    public void doSearch() {
        controller.doSearch(vacancyRequest.getSearchRequest());
    }
    protected String getJsonFromRequest() throws IOException {
        String res = "qq";
        try(BufferedReader reader = req.getReader()) {
            res = reader.readLine();
        }
        return res;
    }
    protected VacancyRequest getPojoFromJson(String jsonString) throws IOException {
        VacancyRequest vacancyRequest;
        try {
            vacancyRequest = objectMapper.readValue(jsonString, VacancyRequest.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
        return vacancyRequest;
    }
}
