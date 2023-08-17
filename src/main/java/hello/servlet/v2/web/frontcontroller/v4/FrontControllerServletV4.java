package hello.servlet.v2.web.frontcontroller.v4;

import hello.servlet.v2.web.frontcontroller.MyView;
import hello.servlet.v2.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.v2.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.v2.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {


    private final Map<String, ControllerV4> controllers = new HashMap<>();

    public FrontControllerServletV4() {
        controllers.put("/front-controller/v4/members/new-form", MemberFormControllerV4.getInstance());
        controllers.put("/front-controller/v4/members/save", MemberSaveControllerV4.getInstance());
        controllers.put("/front-controller/v4/members", MemberListControllerV4.getInstance());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV4 controllerv4 = controllers.get(requestURI);

        if (controllerv4 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // paramMap
        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();
        String viewName = controllerv4.process(paramMap, model);

        MyView view = viewResolver(viewName);
        view.render(model, request, response);

    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
