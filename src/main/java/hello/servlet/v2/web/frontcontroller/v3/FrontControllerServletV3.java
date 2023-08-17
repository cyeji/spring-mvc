package hello.servlet.v2.web.frontcontroller.v3;

import hello.servlet.v2.web.frontcontroller.ModelView;
import hello.servlet.v2.web.frontcontroller.MyView;
import hello.servlet.v2.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.v2.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.v2.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {


    private final Map<String, ControllerV3> controllers = new HashMap<>();

    public FrontControllerServletV3() {
        controllers.put("/front-controller/v3/members/new-form", MemberFormControllerV3.getInstance());
        controllers.put("/front-controller/v3/members/save", MemberSaveControllerV3.getInstance());
        controllers.put("/front-controller/v3/members", MemberListControllerV3.getInstance());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV3 controllerv3 = controllers.get(requestURI);

        if (controllerv3 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // paramMap
        Map<String, String> paramMap = createParamMap(request);

        ModelView modelView = controllerv3.process(paramMap);

        MyView view = viewResolver(modelView);

        view.render(modelView.getModel(), request, response);

    }

    private static MyView viewResolver(ModelView modelView) {
        return new MyView("/WEB-INF/views/" + modelView.getViewName() + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
