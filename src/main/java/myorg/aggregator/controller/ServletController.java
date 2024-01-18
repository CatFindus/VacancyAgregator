package myorg.aggregator.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import myorg.aggregator.model.Model;
import myorg.aggregator.model.ModelFabric;
import myorg.aggregator.view.JsonResponceTestView;
import myorg.aggregator.view.JsonView;
import myorg.aggregator.view.View;
import myorg.aggregator.view.ViewConstants;
import myorg.aggregator.vo.Vacancy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "searchServlet", urlPatterns = "/search")
public class ServletController extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(JsonView.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            View view = new JsonResponceTestView(req, resp);
            Model model = ModelFabric.getModel(view);
            Controller controller = new Controller(model);
            view.setController(controller);
            view.doSearch();
        } catch (IOException e) {
            logger.error(ViewConstants.LOGGER_JSONVIEW_WARN_SEND_ERROR, e);
            returnResponseError(ViewConstants.LOGGER_JSONVIEW_WARN_SEND_ERROR, resp);
        }
        //HttpSession session = req.getSession();
        //session.setAttribute("vacancy_list", vacancies);
        //RequestDispatcher rd = req.getRequestDispatcher("pages/searchresult.html");
        //rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            View view = new JsonView(req, resp);
            Model model = ModelFabric.getModel(view);
            Controller controller = new Controller(model);
            view.setController(controller);
            view.doSearch();
        } catch (IOException e) {
            logger.error(ViewConstants.LOGGER_JSONVIEW_WARN_SEND_ERROR, e);
            returnResponseError(ViewConstants.LOGGER_JSONVIEW_WARN_SEND_ERROR, resp);
        }
    }
    private void returnResponseError(String msg, HttpServletResponse resp) {
        try {
            resp.sendError(400, msg);
        } catch (IOException e) {
            logger.error(ViewConstants.LOGGER_JSONVIEW_WARN_SEND_ERROR, e);
        }
    }
}
